<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="/spring-form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Login: <security:authentication property="name" /> </h2>

<form:form method="POST" commandName="owner">
	<table>
		<tr>
			<td>Login właściciela :</td>
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