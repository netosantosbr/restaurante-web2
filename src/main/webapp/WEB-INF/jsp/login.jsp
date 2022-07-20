<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Realizar Login</title>
</head>
<body>
<h1>LOGIN CLIENTE</h1>

<a href="/">HOME PAGE</a>
<form method="post" action="/validaLogin">
	<label>Login:</label>
	<input type="text" name="cpf" required/>
	<label>Senha: </label>
	<input type="password" name="senha" required/>
	<input type="submit" value="Entrar"/>
</form>
${error}
</body>
</html>