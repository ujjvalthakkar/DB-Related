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
		<h1>List of all the Subscribers</h1>
		<div class="row">
			<div class="col-md-12">
				<c:if test="${empty sessionScope.subscriberList}">
					<h1>No Subscribers to display currently!!</h1>
				</c:if>
				<c:if test="${not empty sessionScope.subscriberList}">
					<div class="table-responsive">
						<table id="mytable" class="table table-bordred table-striped">
							<thead>
								<tr>
									<th>Full Name</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach items="${sessionScope.subscriberList}" var="subscriber">
									<tr>
										<td>${subscriber.subFullname}</td>
										<td>${subscriber.subFname}</td>
										<td>${subscriber.subLname}</td>
										<td><form action="editSubscriber.htm" method="post"> 
												<input type="hidden" name="subscriberId"
													value="${subscriber.subId}" />
												<button type="submit" class="btn btn-primary btn-xs">
													<span class="glyphicon glyphicon-pencil"></span>
												</button>
											</form></td>
										<td>
											<form action="deleteSubscriber.htm" method="post">
												<input type="hidden" name="subscriberId"
													value="${subscriber.subId}" />
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