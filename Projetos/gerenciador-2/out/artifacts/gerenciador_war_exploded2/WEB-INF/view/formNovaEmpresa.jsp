<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkServeletNovaEmpresa"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
	
    <form action="${linkServeletNovaEmpresa }" method="post">
        <h1>Cadastra Empresas</h1>
        <c:import url="logout-parcial.jsp"/>
        <p>Nome: </p> <input type="text" name="nome">
        <p>Data: </p> <input type="text" name="data">
        <input hidden="hidden" name="acao" value="NovaEmpresa">
        <br>
        <button type="submit">Enviar</button>
    </form>
</body>
</html>