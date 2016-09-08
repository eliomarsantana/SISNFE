<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulário do Emitente</title>

<style>
.error {
	color: #ff0000;
}
</style>

</head>

<body>

	<h2>Formulário de Cadastro</h2>

	<form:form method="POST" modelAttribute="emitente">
		<form:input type="hidden" path="idEmitente" id="idEmitente" />
		<table>

			<tr>
				<td><label for="nomeRazaoSocial">Razão Social: </label></td>
				<td><form:input path="nomeRazaoSocial" id="nomeRazaoSocial" /></td>
				<td><form:errors path="nomeRazaoSocial" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="nomeFantasia">Nome Fantasia: </label></td>
				<td><form:input path="nomeFantasia" id="nomeFantasia" /></td>
				<td><form:errors path="nomeFantasia" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="cnpj">CNPJ: </label></td>
				<td><form:input path="cnpj" id="cnpj" /></td>
				<td><form:errors path="cnpj" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="inscricaoEstadual">Inscrição Estadual: </label>
				</td>
				<td><form:input path="inscricaoEstadual" id="inscricaoEstadual" /></td>
				<td><form:errors path="inscricaoEstadual" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="inscricaoMunicipal">Inscricao Municipal:
				</label></td>
				<td><form:input path="inscricaoMunicipal"
						id="inscricaoMunicipal" /></td>
				<td><form:errors path="inscricaoMunicipal" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="cnaeFiscal">CNAE Fiscal: </label></td>
				<td><form:input path="cnaeFiscal" id="cnaeFiscal" /></td>
				<td><form:errors path="cnaeFiscal" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="regimeTributario">Regime Tributário: </label></td>
				<td><form:input path="regimeTributario" id="regimeTributario" /></td>
				<td><form:errors path="regimeTributario" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="logotipo">Logotipo: </label></td>
				<td><form:input path="logotipo" id="logotipo" /></td>
				<td><form:errors path="logotipo" cssClass="error" /></td>
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
	<a href="<c:url value='/list' />">Lista de todos os Emitentes</a>
</body>
</html>