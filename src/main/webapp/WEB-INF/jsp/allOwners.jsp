<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page errorPage="addOwnerError.jsp" %>

<html>
<head>
<style type="text/css">
/* <![CDATA[ */
.name {
  text-indent:0cm;
  color: red;
}

.application {
  text-indent:0.5cm;
  color: blue;
}

.licence {
  text-indent:1cm;
  color: green;
}
/* ]] */
</style>

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
<p>Owners size:<c:out value="${ownersSize}"/></p>

<!-- wypisywanie licencji -->
<c:forEach var="itowner" items="${owners}">
	<div class="name"><c:out value="${itowner.ownerSignature}"/></div>
	<c:forEach var="itapp" items="${itowner.applications}">
	  <div class="application"><c:out value="${itapp.applicationSignature}"/><br /></div>
	  <c:forEach var="itlic" items="${itapp.licences}">
	  	<div class="licence"><c:out value="${itlic.licenceSignature}"/><br /></div>
	  </c:forEach>
	</c:forEach> 
</c:forEach>  

</body>
</html>