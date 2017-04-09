<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/loginstyle.css" />
<link rel="stylesheet" href="/css/mainStyle.css" />

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>

<title>Log in with you account</title>

</head>
<body>
	<div class="container">
		<div class="text-center" style="padding:50px 0">
		<div class="logo">login</div>
		<div class="login-form-1">
			<form:form id="login-form" class="text-left" action="/login" method="POST">
				<div class="login-form-main-message"></div>
				<div class="main-login-form">
					<div class="login-group">
						<div class="form-group">
							<label for="lg_username" class="sr-only">Username</label>
							<input type="text" class="form-control" name="username" placeholder="username">
						</div>
						<div class="form-group">
							<label for="lg_password" class="sr-only">Password</label>
							<input type="password" class="form-control" name="password" placeholder="password">
						</div>
						<div class="form-group login-group-checkbox">
							<input type="checkbox" name="remember">
							<label for="remember">remember</label>
						</div>
					</div>
					<button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
				</div>
				<div class="etc-login-form">
				    <p>forgot your password? <a href="#">click here</a></p>
				    <p>new user? <a href="#">create new account</a></p>
				</div>
			</form:form>
		</div>
		</div>
	</div>
</body>
</html>