<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
<table border="0" width="100%" height="100%">
	<tr width="100%" height="30%" bgcolor="cyan">
		<td colspan="2"><tiles:insertAttribute name="header"/></td>
	</tr>
	<tr width="100%" height="60%">
		<td width="40%" bgcolor="lightblue"><tiles:insertAttribute name="menu"/></td>
		<td width="60%" bgcolor="yellow"><tiles:insertAttribute name="body"/></td>
	</tr>
	<tr width="100%" height="10%">
		<td colspan="2" bgcolor="pink"><tiles:insertAttribute name="footer"/></td>
	</tr>
</table>
</body>
</html>