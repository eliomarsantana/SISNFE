<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulário do Cliente</title>

<style>
.error {
	color: #ff0000;
}
</style>

</head>

<body>

	<h2>Cliente</h2>
	
	<form:form method="POST" modelAttribute="cliente" class="form-horizontal" role="form">
		<form:input type="hidden" path="idCliente" id="idCliente" />
		<table>

			<tr>
				<td><label for="nomeRazaoSocial">Nome Razão Social: </label></td>
				<td><form:input path="nomeRazaoSocial" id="nomeRazaoSocial" /></td>
				<td><form:errors path="nomeRazaoSocial" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="tipoDocumento">Tipo Documento: </label></td>
				<td><form:input path="tipoDocumento" id="tipoDocumento" /></td>
				<td><form:errors path="tipoDocumento" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="cnpj">CNPJ: </label></td>
				<td><form:input path="cnpj" id="cnpj" /></td>
				<td><form:errors path="cnpj" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="cpf">CPF: </label></td>
				<td><form:input path="cpf" id="cpf" /></td>
				<td><form:errors path="cpf" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="inscricaoEstadual">Inscrição Estadual:
				</label></td>
				<td><form:input path="inscricaoEstadual" id="inscricaoEstadual" /></td>
				<td><form:errors path="inscricaoEstadual" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="isentoIcms">Isento ICMS: </label></td>
				<td><form:input path="isentoIcms" id="isentoIcms" /></td>
				<td><form:errors path="isentoIcms" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="inscricaoSuframa">Inscrição Suframa: </label></td>
				<td><form:input path="inscricaoSuframa" id="inscricaoSuframa" /></td>
				<td><form:errors path="inscricaoSuframa" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" />
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form:form>
	<br />
	<br /> Ir para
	<a href="<c:url value='/list' />">Lista de todos os Clientes</a>
</body>
</html>