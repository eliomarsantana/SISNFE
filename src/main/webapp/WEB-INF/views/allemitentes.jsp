<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro de Emitente</title>
</head>


<body>
	<h2>Lista de Emitentes</h2>	
	<table>
		<tr>
			<td>Razao Social</td><td>Nome Fantasia</td><td>Inscricao Estadual</td><td>CNPJ</td><td></td>
		</tr>
		<c:forEach items="${emitentes}" var="emitente">
			<tr>
			<td>${emitente.nomeRazaoSocial}</td>
			<td>${emitenteemitente.nomeFantasia}</td>
			<td>${emitente.inscricaoEstadual}</td>
			<td><a href="<c:url value='/edit-${emitente.cnpj}-emitente' />">${emitente.cnpj}</a></td>
			<td><a href="<c:url value='/delete-${emitente.cnpj}-emitente' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="<c:url value='/new' />">Adicionar novo Emitente</a>
</body>
</html>