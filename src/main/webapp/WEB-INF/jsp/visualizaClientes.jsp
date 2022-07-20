<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=1'>
		<tr>
			<th>CPF</th>
			<th>Nome</th>
			<th>Telefone p/ Contato</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${listaDeClientes}" var="cliente">
			<tr>
				<td>${cliente.getCpf()}</td>
				<td>${cliente.getNome()}</td>
				<td>${cliente.getTelefoneContato()}</td>
				<td>${cliente.getEmail()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>