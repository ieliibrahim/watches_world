<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Access Denied</title>

<style>
body {
	font-family: 'Ropa Sans', sans-serif;
	margin-top: 30px;
	background-color: #F0CA00;
	background-color: #F3661C;
	text-align: center;
	color: #fff;
}

.error-heading {
	margin: 50px auto;
	width: 250px;
	border: 5px solid #fff;
	font-size: 126px;
	line-height: 126px;
	border-radius: 30px;
	text-shadow: 6px 6px 5px #000;
}

.error-heading img {
	width: 100%;
}

.error-main h1 {
	font-size: 72px;
	margin: 0px;
	color: #F3661C;
	text-shadow: 0px 0px 5px #fff;
}
</style>
</head>
<body>
	<div class="error-main">
		<h1>Oops!</h1>
		<div class="error-heading">403</div>
		<p>
			Dear <strong>${loggedinuser}</strong> you do not have permission to
			access the document or program that you requested.
		</p>
		<span class="floatRight"><a href="<c:url value="/logout" />">Logout</a></span>
	</div>

</body>
</html>