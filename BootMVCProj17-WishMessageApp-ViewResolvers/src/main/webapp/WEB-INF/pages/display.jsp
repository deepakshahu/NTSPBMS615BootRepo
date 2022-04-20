<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Result</title>
</head>
<body>
	<h1 style="color: red; text-align: center">Result Page</h1>
	<p align="center">
		<b>System Date and Time :: ${sysDate}</b><br> <b>Wish Message:: ${wMsg}</b><br>
		<b>Wish Message :: <c:out value="${wMsg}"></c:out></b>
	</p>
	<br>
	<h1 style="text-align: center">
		<a href="./">Go to Home</a>
	</h1>
</body>
</html>