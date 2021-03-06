<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Регистрация</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="header"><a href="index">Гостевая книга</a>
		<div class="menu">
			<a href="signIn.jsp">Вход</a>
		</div>
	</div>
	<div class="content">
		<h2>Регистрация</h2>
		<form action="signUp" method="post">
			<div>Имя:</div><input type="text" name="login" />
			<div>Пароль:</div><input type="password" name="password">
			<br><input type="submit" value="Регистрация"/>
		</form>
		<c:if test="${not empty errorMessage}">
			<div><c:out value="${errorMessage }"></c:out></div>
		</c:if>
	</div>
</body>
</html>