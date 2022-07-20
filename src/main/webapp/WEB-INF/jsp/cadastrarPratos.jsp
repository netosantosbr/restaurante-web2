<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post action="/realizaCadastroPrato">
Nome: <input required type="text" name="nome"/>
Descricao: <input required type="text" name="descricao"/>
URL: <input required type="text" name="url"/>
Preco: <input required type="number" name="preco"/>
<input type="submit" value="Cadastrar Prato">
</form>

</body>
</html>