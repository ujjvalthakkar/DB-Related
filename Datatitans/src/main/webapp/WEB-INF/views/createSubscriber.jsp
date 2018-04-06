<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	function show(elem) {
		if (elem.value == 'Ogranization') {
			document.getElementById('FullName').style.display = "block";
			document.getElementById('fName').style.display = "none";
			document.getElementById('lName').style.display = "none";
		}

		if (elem.value == 'Individual') {
			document.getElementById('FullName').style.display = "none";
			document.getElementById('fName').style.display = "block";
			document.getElementById('lName').style.display = "block";
		}
	}
</script>
</head>
<body>
	<div class="container">
		<h1>Add a new Subscriber</h1>
		<div class="jumbotron">
			<form action="addSubscriber.htm" method="post"
				class="form-horizontal" novalidate>
				<div class="form-group">
					<label class="col-md-3 control-label">Subscriber Type:</label>
					<div class="col-md-6">
						<select name="addresstype" onchange="show(this)"
							class="form-control">
							<option value="Individual">Individual</option>
							<option value="Ogranization" selected="selected">Ogranization</option>
						</select>
					</div>
				</div>

				<div class="form-group" id="FullName">
					<label class="col-md-3 control-label">Full Name:</label>
					<div class="col-md-6">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-briefcase"></i></span> <input type="text"
								name="fullname" class="form-control" required />
						</div>
					</div>
				</div>
				<div class="form-group" id="fName" style="display: none">
					<label class="col-md-3 control-label">First Name:</label>
					<div class="col-md-6">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span><input type="text"
								name="fname" class="form-control" required />
						</div>
					</div>
				</div>
				<div class="form-group" id="lName" style="display: none">
					<label class="col-md-3 control-label">Last Name:</label>
					<div class="col-md-6">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span><input type="text"
								name="lname" class="form-control" required />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label"></label>
					<div class="col-md-3">
						<input type="submit" class="btn btn-primary"
							value="Create Subscriber" />
					</div>
					<div class="col-md-3">
						<a href="home.htm" class="btn btn-primary">Home</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>