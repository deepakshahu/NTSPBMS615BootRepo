<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" 
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
<meta charset="ISO-8859-1">
<title>Register Politician</title>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-center text-white">
				<h3>REGISTER POLITICIAN</h3>
			</div>
			<div class="card-body">
				<form:form modelAttribute="pp">
					<table class="table table-hover table-bordered">
						<tr>
							<td>Politician Name ::</td>
							<td><form:input path="pname" class="form-control" /></td>
						</tr>
						<tr>
							<td>Politician Party Name ::</td>
							<td><form:input path="party" class="form-control" /></td>
						</tr>
						<tr>
							<td>Politician DOB ::</td>
							<td><form:input path="dob" type="date" class="form-control" /></td>
						</tr>
						<tr>
							<td>Politician DOJ ::</td>
							<td><form:input path="doj" type="date" class="form-control" /></td>
						</tr>
						<tr>
							<td>Having Constitution Post ? ::</td>
							<td><form:radiobutton path="consPost" value="true" />YES &nbsp;&nbsp;
							<form:radiobutton path="consPost" value="false" />NO</td>
						</tr>
						<tr>
							<td colspan="2" align="center"><button class="btn btn-info" type="submit">REGISTER POLITICIAN</button></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
	<noscript>
		<h1 style="color: red; text-align: center">Please enable
			JavaScript!</h1>
	</noscript>
</body>
</html>