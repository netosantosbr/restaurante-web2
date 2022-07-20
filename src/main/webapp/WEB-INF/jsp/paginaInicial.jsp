<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	img{
		max-width: 25%;
		max-height: 25%;
	}
</style>
</head>
<body>
	<h1>Página Inicial do Cliente</h1>
		<table border="1" border-style="dotted">
			<tr>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Imagem</th>
				<th>Preço</th>
			</tr>

			<c:forEach items="${lp}" var="pr">
				<tr>
					<td>${pr.getNome()}</td>

					<td>${pr.getDescricao()}</td>

					<td><img src="${pr.getUrl()}" /></td>

					<td>${pr.getPreco()}</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>