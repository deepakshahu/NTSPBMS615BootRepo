<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
	<h1 style="color: red; text-align: center">Sorry for the
		inconvenience</h1>
	<table border="1" align="center" bgcolor="cyan">
	<tr>
		<td>Status</td>
		<td>${status}</td>
	</tr>
	<tr>
		<td>Message</td>
		<td>${message}</td>
	</tr>
	<tr>
		<td>TimeStamp</td>
		<td>${timestamp}</td>
	</tr>
	<tr>
		<td>Path</td>
		<td>${path}</td>
	</tr>
	<tr>
		<td>Trace</td>
		<td>${trace}</td>
	</tr>
	</table>
</body>
</html>