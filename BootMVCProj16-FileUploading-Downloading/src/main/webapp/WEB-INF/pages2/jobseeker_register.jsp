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
<title>Job Seeker Register</title>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-center text-white">
				<h3>JOB SEEKER REGISTRATION</h3>
			</div>
			<div class="card-body">
				<form:form modelAttribute="js" enctype="multipart/form-data">
					<table class="table table-hover table-bordered">
						<tr>
							<td>Name ::</td>
							<td><form:input path="jsName" class="form-control" /></td>
						</tr>
						<tr>
							<td>Address ::</td>
							<td><form:input path="jsAddrs" class="form-control" /></td>
						</tr>
						<tr>
							<td>Select Resume ::</td>
							<td><form:input type="file" path="resume" class="form-control" /></td>
						</tr>
						<tr>
							<td>Select Photo ::</td>
							<td><form:input type="file" path="photo" class="form-control" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><button class="btn btn-info" type="submit">REGISTER</button></td>
						</tr>
					</table>
				</form:form>
			</div>
			<div class="card-footer text-center">
				<a class="btn btn-info" href="./">Home <i class="fa fa-home"
					aria-hidden="true"></i></a>
			</div>
		</div>
	</div>
</body>
</html>