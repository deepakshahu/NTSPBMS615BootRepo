<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Report</title>
</head>
<body>
	<%-- <b>Model data is :: </b>
	<br>
	<b>Name :: ${name}</b>
	<br>
	<b>Age :: ${age}</b>
	<br>
	<b>Address :: ${addrs}</b>	 --%>

	<%-- 	<b>Model data(Array, Collections) is :: </b>
	<br>
	<b>Favourite Colors(Array) is :: </b>
	<c:if test="${!empty favColors}">
		<c:forEach var="color" items="${favColors}">
			${color},
		</c:forEach>
	</c:if>
	<br>
	<b>Nick Names(List Collection) is :: </b>
	<c:if test="${!empty nickNames}">
		<c:forEach var="name" items="${nickNames}">
			${name},
		</c:forEach>
	</c:if>
	<br>
	<b>Phone Numbers(Set Collection) is :: </b>
	<c:if test="${!empty phoneNumbers}">
		<c:forEach var="phone" items="${phoneNumbers}">
			${phone},
		</c:forEach>
	</c:if>
	<br>
	<b>ID Details(Map Collection) is :: </b>
	<c:if test="${!empty idDetails}">
			${idDetails.aadhar},
			${idDetails.voterId},
			${idDetails.panNo}
	</c:if>
	<br>
	<b>ID Details(Map Collection) is :: </b>
	<c:if test="${!empty idDetails}">
		<c:forEach var="id" items="${idDetails}">
			<br>${id.key} <--> ${id.value}<br>
		</c:forEach>
	</c:if> --%>

	<%-- <b>Model data is :: </b>
	<br>
	<c:if test="${!empty prodData}">
		Product ID :: ${prodData.pid} <br>
		Product Name :: ${prodData.pname}<br>
		Product Price :: ${prodData.price}<br>
		Product qty :: ${prodData.qty}
	</c:if>
	<br> --%>

	<h1 style="color:red;text-align:center"><b>List of Model data is :: </b></h1>
	<br>
	<c:choose>
		<c:when test="${!empty prodList}">
			<table align="center" border="1" bgcolor="cyan">
				<tr>
					<th>PID</th>
					<th>PNAME</th>
					<th>PRICE</th>
					<th>QTY</th>
				</tr>
				<c:forEach var="prod" items="${prodList}">
					<tr>
						<td>${prod.pid}</td>
						<td>${prod.pname}</td>
						<td>${prod.price}</td>
						<td>${prod.qty}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">No Records found</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>