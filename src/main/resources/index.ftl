<head>
<title>BookFace Login</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://bootswatch.com/darkly/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<main id="content" role="main" xmlns="http://www.w3.org/1999/html">

<div class="panel panel-default">
	<div class="panel-body">

		<div class="jumbotron">
			<h1 align="center">Bookface Login</h1>
		</div>

		<form action="login-details" method="post">
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">Username:</span><input
					id="username-input" name="username" class="form-control"
					aria-describedby="basic-addon1" />
			</div>

			<br />

			<div class="input-group">
				<span class="input-group-addon" id="basic-addon2">Password:</span><input
					id="password-input" type="password" name="password"
					class="form-control" />
			</div>
			<br /> <input type="submit" class="btn btn-primary" id="submit-button"
				aria-describedby="basic-addon2" />
		</form>
	</div>
</div>

</main>