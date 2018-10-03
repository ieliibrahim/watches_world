<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Watches World Admin</title>

<link
	href="<c:url value="resources/vendors/bootstrap/dist/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="resources/vendors/font-awesome/css/font-awesome.min.css" />"
	rel="stylesheet">
<link href="<c:url value="resources/css/app/WWApp.css" />"
	rel="stylesheet">

<link rel="icon" href="resources/images/app/favicon.ico"
	type="image/ico" />
<head>
<title>Watches World</title>
<body>

	<section class="login-block">
		<div class="container">
			<div class="row">

				<div class="col-md-4 login-sec">

					<h2 class="text-center">Login Now</h2>

					<c:url var="loginUrl" value="/login" />
					<form action="${loginUrl}" method="post">
						<c:if test="${param.error != null}">
							<div class="alert alert-danger">
								<p>Invalid Username or Password.</p>
							</div>
						</c:if>
						<c:if test="${param.logout != null}">
							<div class="alert alert-success">
								<p>You have been logged out successfully.</p>
							</div>
						</c:if>

						<div class="form-group">
							<label for="username" class="text-uppercase">Username</label> <i
								class="fa fa-user"></i> <input type="text" name="username"
								class="form-control" placeholder="Username" required autofocus="autofocus">

						</div>
						<div class="form-group">
							<label for="password" class="text-uppercase">Password</label> <i
								class="fa fa-lock"></i> <input type="password" name="password"
								class="form-control" placeholder="Enter Password" required>
						</div>

						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="form-check">
							<button type="submit" class="btn btn-login float-right">Login</button>
						</div>
					</form>

				</div>

				<div class="col-md-8 banner-sec">
					<div id="carouselExampleIndicators" class="carousel slide"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li style="background-color: #e26c67"
								data-target="#carouselExampleIndicators" data-slide-to="0"
								class="active"></li>
							<li style="background-color: #e26c67"
								data-target="#carouselExampleIndicators" data-slide-to="1"></li>
							<li style="background-color: #e26c67"
								data-target="#carouselExampleIndicators" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img class="d-block w-100"
									src="resources/images/app/carousel/img1.jpg" width="40%"
									height="40%" alt="First slide">

								<div class="carousel-caption d-none d-md-block">
									<table class="table">
										<tbody>
											<tr align="left">
												<td>BRAND:</td>
												<td>AUDEMARS PIGUET</td>
											</tr>
											<tr align="left">
												<td>MODEL</td>
												<td>ROYAL OAK CHRONOGRAPH</td>
											</tr>
											<tr align="left">
												<td>YEAR</td>
												<td>2018</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div class="item">
								<img class="d-block w-100"
									src="resources/images/app/carousel/img2.jpg" width="40%"
									height="40%" alt="First slide">

								<div class="carousel-caption d-none d-md-block">
									<table class="table">
										<tbody>
											<tr align="left">
												<td>BRAND:</td>
												<td>AUDEMARS PIGUET</td>
											</tr>
											<tr align="left">
												<td>MODEL</td>
												<td>ROYAL OAK OFFSHORE SUMMER EDITION 2017</td>
											</tr>
											<tr align="left">
												<td>YEAR</td>
												<td>2017</td>
											</tr>
										</tbody>
									</table>
								</div>

							</div>
							<div class="item">
								<img class="d-block w-100"
									src="resources/images/app/carousel/img3.jpg" width="40%"
									height="40%" alt="First slide">

								<div class="carousel-caption d-none d-md-block">
									<table class="table">
										<tbody>
											<tr align="left">
												<td>BRAND:</td>
												<td>HUBLOT</td>
											</tr>
											<tr align="left">
												<td>MODEL</td>
												<td>CLASSIC FUSION QUARTZ</td>
											</tr>
											<tr align="left">
												<td>YEAR</td>
												<td>2018</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<a class="carousel-control-prev" href="#carouselExampleIndicators"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next"
							href="#carouselExampleIndicators" role="button" data-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="resources/vendors/jquery/dist/jquery.min.js"></script>
	<script src="resources/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>