package ua.lviv.lgs.admissionsOffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.lviv.lgs.admissionsOffice.domain.User;
import ua.lviv.lgs.admissionsOffice.service.UserService;

@Controller
public class RegistrationController {
	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public String viewRegistrationForm() {
		return "registration";
	}

	@PostMapping("/registration")
	public String registerUser(User user, Model model, RedirectAttributes redir) {
		if (!userService.addUser(user)) {
			model.addAttribute("message", "Такой пользователь уже существует!");
			return "registration";
		}
		
		redir.addFlashAttribute("message", "Для активации пользователя перейдите по ссылке в письме, отправленном на указанный Вами электронный ящик!");
		return "redirect:/login/";
	}
	
	@GetMapping("/activate/{code}")
    public String activate(@PathVariable String code, Model model) {
        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            model.addAttribute("message", "Пользователь успешно активирован!");
        } else {
            model.addAttribute("message", "Код активации не найден!");
        }

        return "login";
    }
}