<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<style media="all">
span {
	color: red;
}
</style>
<script lang="JavaScript" src="js/validation.js"></script>
<script lang="JavaScript">
			function sendReqForStates(){
				alert("Event is raised");
				frm.action="statesurl";  //request path for handler method
				frm.submit();  //submits the request
			}
</script>
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
				<form:form modelAttribute="emp" onsubmit="return validation(this)"
					name="frm">
					<table class="table table-hover table-bordered">
						<tr>
							<td>Employee Name ::</td>
							<td><form:input path="ename" class="form-control" /> <form:errors
									path="ename" /> <span id="enameErr"></span></td>
						</tr>
						<tr>
							<td>Employee Job ::</td>
							<td><form:input path="job" class="form-control" /> <form:errors
									path="job" /> <span id="jobErr"></span></td>
						</tr>
						<tr>
							<td>Employee Salary ::</td>
							<td><form:input path="sal" class="form-control" /> <form:errors
									path="sal" /> <span id="salErr"></span></td>
						</tr>
						<tr>
							<td>Select Country ::</td>
							<td><form:select path="country"
									onchange="sendReqForStates(this)" class="form-control">
									<form:options items="${countriesInfo}" />
								</form:select></td>
						</tr>
						<tr>
							<td>Select State ::</td>
							<td><form:select path="state" class="form-control">
									<form:options items="${statesInfo}" />
								</form:select></td>
						</tr>
						<tr>
							<td>Select Gender ::</td>
							<td><form:radiobutton path="gender" value="M" label="Male" />
								<form:radiobutton path="gender" value="F" label="Female" /></td>
						</tr>
						<tr>
							<td>Select Hobbies ::</td>
							<td><form:checkboxes items="${hobbiesInfo}" path="hb"/></td>
						</tr>
						<tr>
							<td>Select Courses ::</td>
							<td><form:select path="courses" multiple="multiple" size="3" class="form-control">
								<form:options items="${coursesInfo}"/></form:select></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><button class="btn btn-info"
									type="submit">REGISTER EMPLOYEE</button></td>
						</tr>
					</table>
					<form:hidden path="vflag" />
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