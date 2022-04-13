<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
<meta charset="ISO-8859-1">
<title>Customer Register</title>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-center text-white">
				<h3>
					<sp:message code="cust.registration.title" />
				</h3>
			</div>
			<div class="card-body">
				<form:form modelAttribute="cust">
					<table class="table table-hover table-bordered">
						<tr>
							<td><sp:message code="cust.registration.name" /> ::</td>
							<td><form:input path="cname" class="form-control" /></td>
						</tr>
						<tr>
							<td><sp:message code="cust.registration.addrs" /> ::</td>
							<td><form:input path="caddrs" class="form-control" /></td>
						</tr>
						<tr>
							<td><sp:message code="cust.registration.billAmt" /> ::</td>
							<td><form:input path="billAmount" class="form-control" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><button class="btn btn-info"
									type="submit">
									<sp:message code="cust.btn.register" />
								</button></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<p align="center">
		<a href="?lang=fr_FR">Français</a>&nbsp;&nbsp; <a href="?lang=de_DE">Deutsch</a>&nbsp;&nbsp;
		<a href="?lang=hi_IN">हिन्दी</a>&nbsp;&nbsp; <a href="?lang=en_US">English</a>
	</p>
</body>
</html>