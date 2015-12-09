<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Гостевая книга</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="header"><a href="index">Гостевая книга</a>
		<div class="menu">
		<c:if test="${empty username}">
			<a href="signIn.jsp">Вход</a><a href="signUp.jsp">Регистрация</a>
		</c:if>
		 <c:if test="${not empty username}">
			<div>Привет, <c:out value="${username}"/>! <a href="signOut">Выход</a></div>
		</c:if> 
		</div>
	</div>
	<div class="content">
		<div class="comments">
			<h2>Сообщения:</h2>
			<c:if test="${not empty messages}">
				<c:forEach var="message" items="${messages}">
					<div class="comment"><h3>${message.username}</h3><p>${message.content}</p></div>
				</c:forEach>
			</c:if>			
		</div>	
	 	<c:if test="${not empty username}">
			<form action="addMessage" method="post">
				<textarea rows="10" name="content"></textarea>
				<br><input type="submit" value="Отправить"/>
				</form>
		</c:if> 
	</div>
</body>
</html>