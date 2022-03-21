<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Register</title>
</head>
<body>
	<h1 style="color: red; text-align: center">Student Registration Page</h1>
	<form:form modelAttribute="stud">
		<table border="1" align="center" bgcolor="cyan">
			<tr>
				<td>Student Number :</td>
				<td><form:input path="sno"/></td>
			</tr>
			<tr>
				<td>Student Name :</td>
				<td><form:input path="sname"/></td>
			</tr>
			<tr>
				<td>Student Address :</td>
				<td><form:input path="sadd"/></td>
			</tr>
			<tr>
				<td>Student Average :</td>
				<td><form:input path="avg"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>