
<%@page import="java.util.List"%>
<%@ page import="br.com.vita.academy.gerenciador2.Empresa" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	List<Empresa> empresas = (List<Empresa>)request.getAttribute("empresas");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de Empresas</h1>
	<c:if test="${not empty empresa }">
		<h1>Empresa ${ empresa } Cadastrada com Sucesso!</h1>
	</c:if>
	<ul>
		<c:forEach items="${ empresas }" var = "empresa">
			
			<li>${empresa.id } - ${ empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/> - 
				
				<a href="/gerenciador_2_war_exploded/mostrarEmpresa?id=${empresa.id }">editar</a>
				<a href="/gerenciador_2_war_exploded/removeEmpresa?id=${empresa.id }">deletar</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>