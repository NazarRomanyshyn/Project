<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <link href="css/app.css" rel="stylesheet" type="text/css">
    <title>Spring Security</title>
</head>

<body class="security-app">
    <div class="lc-block">
        <div class="alert-danger">
            <h3>У Вас не має доступа до цієї сторінки!</h3>
        </div>
        <form action="/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="submit" class="button red big" value="Увійти під іншим користувачем" />            
        </form>
    </div>
</body>

</html>