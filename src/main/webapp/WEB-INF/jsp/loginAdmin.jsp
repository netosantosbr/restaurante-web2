<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>LOGIN ADMINISTRADOR</h1>
<a href="/">HOME PAGE</a>
<form method="post" action="/validaLoginAdmin">
	<label>Login:</label>
	<input type="text" name="nome" required/>
	<label>Senha: </label>
	<input type="password" name="senha" required/>
	<input type="submit" value="Entrar"/>
</body>
</html>