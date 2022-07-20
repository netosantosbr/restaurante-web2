<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
<style><%@include file="/WEB-INF/style.css"%></style>
</head>
<body>
<h1>Cadastro</h1>

<div class="div-form-cadastro">
<a href="/">HOME PAGE</a>
<form method="post" action="/cadastro">
CPF: <input required type="text" placeholder="cpf" id="input-cpf" name="cpf">
Nome: <input required type="text" placeholder="Nome" id="input-nome" name="nome">
Telefone para Contato: <input required type="text" placeholder="Telefone para contato" id="telefone-contato" name="telefoneContato"/>
Email: <input required type="text" placeholder="Email" id="input-email" name="email"/>
Senha: <input required type="password" placeholder="Senha" id="input-senha"name="senha"/>
<input type="submit" value="Cadastrar"/>
</form>
${msg}
</div>
</body>
</html>