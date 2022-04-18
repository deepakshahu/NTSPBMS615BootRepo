<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
<meta charset="ISO-8859-1">
<title>JobSeeker Report</title>
</head>
<body>
	<br>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-center text-white">
				<h3>JOB SEEKER'S REPORT</h3>
			</div>
			<c:choose>
				<c:when test="${!empty jsList}">
					<div class="card-body">
						<table class="table table-hover table-bordered">
							<tr class="bg-info text-white">
								<th>JS ID</th>
								<th>JS NAME</th>
								<th>JS ADDRESS</th>
								<th>RESUME</th>
								<th>PHOTO</th>
							</tr>
							<c:forEach var="info" items="${jsList}">
								<tr>
									<td>${info.jsId}</td>
									<td>${info.jsName}</td>
									<td>${info.jsAddrs}</td>
									<td><a class=" btn btn-warning"
										href="download?jsId=${info.jsId}&type=resume">DOWNLOAD
											RESUME <i class="fa fa-download" aria-hidden="true"></i>
									</a></td>
									<td><a class=" btn btn-success"
										href="download?jsId=${info.jsId}&type=photo">DOWNLOAD
											PHOTO <i class="fa fa-download" aria-hidden="true"></i>
									</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<center>
						<a style="height: 100%; width: 150px" class="btn btn-info" href="register">Add JobSeeker <i class="fa fa-plus-circle" aria-hidden="true"></i></a>
					</center>
					<br>
				</c:when>
				<c:otherwise>
					<h3 style="color: red; text-align: center">RECORDS NOT FOUND</h3>
				</c:otherwise>
			</c:choose>
			<div class="card-footer text-center">
				<a class="btn btn-info" href="./">Home <i class="fa fa-home"
					aria-hidden="true"></i></a>
			</div>
		</div>
	</div>
</body>
</html>