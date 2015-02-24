<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="form" uri="/spring-form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formularz dodawania aplikacji</title>
</head>
<body>

<form:form method="POST" commandName="applicationCommand">
	<table>
		<tr>
			<td>Nazwa aplikacji:</td>
			<td><form:input path="name" /></td>
		</tr>
		
		<tr>
			<td>Podpis aplikacji:</td>
			<td><form:input path="applicationSignature" /></td>
		</tr>
		
		<tr>
			<td>Podpis właściciela:</td>
			<td><form:input path="ownerSignature" /></td>
		</tr>
<%--		
		<tr>
			<td>Password :</td>
			<td><form:password path="password" /></td>
		</tr>
		
--%>
		<tr>
			<td colspan="2"><input type="submit"></td>
		</tr>

	</table>
</form:form>

</body>
</html>