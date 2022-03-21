<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Register</title>
</head>
<body>
	<h1 style="color: red; text-align: center">Student Registration
		Page</h1>
	<form method="POST">
		<table border="1" align="center" bgcolor="cyan">
			<tr>
				<td>Student Number :</td>
				<td><input type="text" name="sno"></td>
			</tr>
			<tr>
				<td>Student Name :</td>
				<td><input type="text" name="sname"></td>
			</tr>
			<tr>
				<td>Student Address :</td>
				<td><input type="text" name="sadd"></td>
			</tr>
			<tr>
				<td>Student Average :</td>
				<td><input type="text" name="avg"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
</body>
</html>