<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME</title>
</head>
<body>
	<h1 style="color: blue; text-align: center">
		<sp:message code="home.title" />
	</h1>
	<br>
	<br>
	<h2 style="color: red; text-align: center">
		<a href="register"> <sp:message code="home.link" />
		</a>
	</h2>
	<h1 style="text-align: center; color: red">Current active locale is :: ${pageContext.response.locale}</h1>
	<fmt:setLocale value="${pageContext.response.locale}" />
	<jsp:useBean id="dt" class="java.util.Date" />
	<p align="center">
		<fmt:formatDate var="fdt" value="${dt}" type="date" dateStyle="FULL" />
		<b>Formatted Date :: ${fdt}</b> <br>
		<fmt:formatDate var="ftime" value="${dt}" type="time" timeStyle="FULL" />
		<b>Formatted Time :: ${ftime}</b> <br>
		<fmt:formatNumber var="fnumber" value="10000000" type="number" />
		<b>Formatted Number :: ${fnumber}</b> <br>
		<fmt:formatNumber var="fcurrency" value="10000000" type="currency" />
		<b>Formatted Currency :: ${fcurrency}</b> <br>
		<fmt:formatNumber var="fpercentage" value="0.5" type="percent" />
		<b>Formatted Percentage :: ${fpercentage}</b> <br>
	</p>
	<br>
	<br>
	<p align="center">
		<a href="?lang=fr_FR">Français</a>&nbsp;&nbsp; <a href="?lang=de_DE">Deutsch</a>&nbsp;&nbsp;
		<a href="?lang=hi_IN">हिन्दी</a>&nbsp;&nbsp; <a href="?lang=en_US">English</a>
	</p>
</body>
</html>