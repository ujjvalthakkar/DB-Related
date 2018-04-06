<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Welcome to Datatitans Healthcare</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Welcome to Datatitans Healthcare</h1>

			<c:if test="${not empty requestScope.msg}">
				<p>${requestScope.msg}</p>
			</c:if>
			<h2>
				<a href="addMember.htm"> Create a new Member</a><br> <br>
				<a href="displayMembers.htm"> Display All Members</a><br> <br>
				<a href="createSubscriber.htm"> Create a new Subscriber</a><br>
				<br> <a href="displaySubscriber.htm"> Display All
					Subscribers</a><br> <br>
			</h2>
		</div>
	</div>

</body>
</html>
