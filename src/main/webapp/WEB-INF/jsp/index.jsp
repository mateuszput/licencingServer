<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Strona index</title>
</head>
<body>
<a href="<c:url value="/j_spring_security_login" />">Login</a>
<a href="<c:url value="/login.jsp" />">Login</a>
<a href="<c:url value="/j_spring_security_logout" />">Logout</a>


<h3>
   Dostępne funkcjonalności:
</h3>

<h3>
   <a href="/licencingServer/addOwner.htm">dodaj właściciela</a> <br />
</h3>

<h3>
   <a href="/licencingServer/addApplication.htm">dodaj aplikacje</a> <br />
</h3>

<h3>
   <a href="/licencingServer/addLicence.htm">dodaj licencje</a> <br />
</h3>

<h3>
   <a href="/licencingServer/selectOwnerApplication.htm">pokaz aplikacje  wlasciciela</a> <br />
</h3>

<h3>
   <a href="/licencingServer/showAllOwners.htm">pokaz wszystkich wlascicieli - admin</a> <br />
</h3>

</body>
</html>