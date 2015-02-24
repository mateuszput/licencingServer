<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Dane właściciela
<hr>
Login    : ${owner.login} <br />
Signature    : ${owner.ownerSignature} <br />

<!-- wypisywanie licencji -->
<c:forEach var="itapp" items="${owner.applications}">
	<b><c:out value="${itapp.name}" /></b>	<br />
	
	<c:forEach var="itlic" items="${itapp.licences}">
		<c:out value="${itlic.name}" />	<br />
	</c:forEach>
</c:forEach>
</body>
</html>