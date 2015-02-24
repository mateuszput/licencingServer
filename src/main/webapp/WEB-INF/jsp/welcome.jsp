<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page errorPage="addOwnerError.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<%@ include file="../css/styl-test.css" %> <!-- ../ -->
</style>
<link rel='stylesheet' href='./css/style.css'>
<title>Welcome page</title>
</head>
<body>
<h1>Witaj na stronie serwera licencyjnego</h1>
<p>To jest strona glowna serwera licencyjnego.</p>
<p>Data: <%= new java.util.Date() %> </p>
<p>Owner:<c:out value="${owner.name}"/></p>
<p>Owners size:<c:out value="${ownersSize}"/></p>

<!-- wypisywanie licencji -->
<c:forEach var="itowner" items="${owners}">
	<c:out value="${itowner.name}"/><br>
	<c:forEach var="itapp" items="${itowner.applications}">
	  <c:out value="${itapp.name}"/><br />
	  <c:forEach var="itlic" items="${itapp.licences}">
	  	<c:out value="${itlic.name}"/><br />
	  </c:forEach>
	</c:forEach> 
</c:forEach>  

<p>Koniec</p>
</body>
</html>