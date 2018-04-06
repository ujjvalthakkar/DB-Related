<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Datatitans Healthcare</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
<link rel='stylesheet' type='text/css'
	href='http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css' />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div class="container-fluid">
		<h1>List of all the members</h1>
		<div class="row">
			<div class="col-md-12">
				<c:if test="${empty sessionScope.memberList}">
					<h1>No Members to display currently!!</h1>
				</c:if>
				<c:if test="${not empty sessionScope.memberList}">
					<div class="table-responsive">
						<table id="mytable" class="table table-bordred table-striped">
							<thead>
								<tr>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Gender</th>
									<th>DOB</th>
									<th>Profession</th>
									<th>SSN</th>
									<th>Address Type</th>
									<th>Building/Apartment Number</th>
									<th>Street Name</th>
									<th>City</th>
									<th>Zip</th>
									<th>Phone Type</th>
									<th>Phone Number</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${sessionScope.memberList}" var="member">
									<tr>
										<td>${member.memberFname}</td>
										<td>${member.memberLname}</td>
										<td>${member.personalInfo.gender}</td>
										<td>${member.personalInfo.dob}</td>
										<td>${member.personalInfo.memberProfession}</td>
										<td>${member.personalInfo.ssn}</td>
										<td>${member.memberAddress.addressType}</td>
										<td>${member.memberAddress.buildingNo}</td>
										<td>${member.memberAddress.streetName}</td>
										<td>${member.memberAddress.city}</td>
										<td>${member.memberAddress.zip}</td>
										<td>${member.memberPhone.phoneType}</td>
										<td>${member.memberPhone.phone}</td>
										<td><form action="editMember.htm" method="post"> 
												<input type="hidden" name="memberId"
													value="${member.memberId}" />
												<button type="submit" class="btn btn-primary btn-xs">
													<span class="glyphicon glyphicon-pencil"></span>
												</button>
											</form></td>
										<td>
											<form action="deleteMember.htm" method="post">
												<input type="hidden" name="memberId"
													value="${member.memberId}" />
												<button class="btn btn-danger btn-xs">
													<span class="glyphicon glyphicon-trash"></span>
												</button>
											</form>
											</p>
										</td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</c:if>
				<br> <br> <a href="home.htm" class="btn btn-primary">Home</a>
			</div>
		</div>
	</div>
</body>
</html>