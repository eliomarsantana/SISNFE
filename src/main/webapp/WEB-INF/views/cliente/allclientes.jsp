<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro de Cliente</title>
</head>


<body>
	<h2>Lista de Clientes</h2>	
	<table>
		<tr>
			<td>Razao Social</td><td>Nome Fantasia</td><td>Inscricao Estadual</td><td>CNPJ</td><td></td>
		</tr>
		<c:forEach items="${clientes}" var="cliente">
			<tr>
			<td>${cliente.nomeRazaoSocial}</td>
			<td>${cliente.nomeFantasia}</td>
			<td>${cliente.inscricaoEstadual}</td>
			<td><a href="<c:url value='/edit-${cliente.cnpj}-cliente' />">${cliente.cnpj}</a></td>
			<td><a href="<c:url value='/delete-${cliente.cnpj}-cliente' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/cliente/new' />">Adicionar novo Cliente</a>
</body>
</html>