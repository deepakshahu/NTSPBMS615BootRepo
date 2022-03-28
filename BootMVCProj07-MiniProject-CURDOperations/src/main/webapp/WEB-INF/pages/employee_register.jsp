<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
<meta charset="ISO-8859-1">
<title>Employee Register</title>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-center text-white">
				<h3>EMPLOYEE REGISTER</h3>
			</div>
			<div class="card-body">
				<form:form modelAttribute="emp">
					<table class="table table-hover table-bordered">
						<tr>
							<td>Employee Name ::</td>
							<td><form:input path="ename" class="form-control" /></td>
						</tr>
						<tr>
							<td>Employee Job ::</td>
							<td><form:input path="job" class="form-control" /></td>
						</tr>
						<tr>
							<td>Employee Salary ::</td>
							<td><form:input path="sal" class="form-control" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><button class="btn btn-info" type="submit">REGISTER EMPLOYEE</button></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>