<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/alterarEmpresa" var="linkServeletAlterarEmpresa"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
	
    <form action="${linkServeletAlterarEmpresa }" method="post">
        <h1>Alterar Empresa</h1>
        <p>Nome: </p> <input type="text" name="nome" value="${empresa.nome }">
        <p>Data: </p> <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>">
			<input type="hidden" name="id" value="${empresa.id }">
		<input type="submit" />
    </form>
</body>
</html>