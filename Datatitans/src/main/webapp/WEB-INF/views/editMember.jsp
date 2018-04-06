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
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
<link rel='stylesheet' type='text/css'
	href='http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css' />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	$(document).ready(function() {
		$("#dob").datepicker();
	});
</script>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div class="container">
		<h1>Update Member: ${sessionScope.member.memberFname} &nbsp&nbsp ${sessionScope.member.memberLname} </h1>
		<form action="updateMember.htm" method="post" class="form-horizontal">
			<div class="form-group">
				<label class="col-md-3 control-label">First Name:</label>
				<div class="col-md-6">
					<input type="text" name="fname"
						value="${sessionScope.member.memberFname}" class="form-control"
						required />
					<input type="hidden" name="memberId" value="${sessionScope.member.memberId}"/>	
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">Last Name:</label>
				<div class="col-md-6">
					<input type="text" name="lname"
						value="${sessionScope.member.memberLname}" class="form-control"
						required />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">DOB:</label>
				<div class="col-md-6">
					<input name="dob" type="text"
						value="${sessionScope.member.personalInfo.dob}"
						class="form-control" id="dob">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">Profession:</label>
				<div class="col-md-6">
					<input type="text" name="profession"
						value="${sessionScope.member.personalInfo.memberProfession}"
						class="form-control" required />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">SSN:</label>
				<div class="col-md-6">
					<input type="text" name="ssn"
						value="${sessionScope.member.personalInfo.ssn}"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">Address Type:</label>
				<div class="col-md-6">
					<select name="addresstype" class="form-control">
						<c:if test="${sessionScope.member.memberAddress.addressType == 'Home'}">
							<option value="Home" selected="selected">Home</option>
							<option value="Work">Work</option>
						</c:if>
						<c:if test="${sessionScope.member.memberAddress.addressType == 'Work'}">
							<option value="Home">Home</option>
							<option value="Work" selected="selected">Work</option>
						</c:if>

					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">Building/Apartment
					Number:</label>
				<div class="col-md-6">
					<input type="text" name="buildingnumber"
						value="${sessionScope.member.memberAddress.buildingNo}"
						class="form-control" required />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">Street Name:</label>
				<div class="col-md-6">
					<input type="text" name="streetname"
						value="${sessionScope.member.memberAddress.streetName}"
						class="form-control" required />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">City:</label>
				<div class="col-md-6">
					<input type="text" name="city"
						value="${sessionScope.member.memberAddress.city}"
						class="form-control" required />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">Zip:</label>
				<div class="col-md-6">
					<input type="text" name="zip"
						value="${sessionScope.member.memberAddress.zip}"
						class="form-control" required />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">Phone Type:</label>
				<div class="col-md-6">
					<select name="phonetype" class="form-control">
						<option value="Home">Home Phone</option>
						<option value="Office">Office Phone</option>
						<option value="Work">Work Phone</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">Phone Number:</label>
				<div class="col-md-6">
					<input type="text" name="phonenumber"
						value="${sessionScope.member.memberPhone.phone}"
						class="form-control" required />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label"></label>
				<div class="col-md-3">
					<input type="submit" class="btn btn-primary" value="Update Member" />
				</div>
				<div class="col-md-3">
					<a href="home.htm" class="btn btn-primary">Home</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>