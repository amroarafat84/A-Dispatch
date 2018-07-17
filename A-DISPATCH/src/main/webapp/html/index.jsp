<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>A-Dispatch</title>
<link rel="stylesheet" href="resources/css/index.css">
<script>
    history.forward();
</script>
</head>
<body>
	<div><img src="resources/photos/12.jpeg" alt="Truck" ></div><br>
	<h1>A-Dispatch</h1>
	<form class="loginform" action="Main" method="post" >
		<input type="text" name="user" placeholder="user name" > <br>
		<input type="password" name="password" placeholder="Password"> <br><br>
		<input type="submit" value="Login">
	</form><br><br>
	<div align="center">
	<a href="html/forgetPassword.jsp" ><button id="btn">ForgetPassword</button></a>
	</div>
	<div align="center">
	<a href="html/shippersignup.jsp" ><button id="btn">Shipper Sign Up</button></a>
	<a href="html/carriersignup.jsp" ><button id="btn">Carrier Sign Up</button></a>
	</div>
	<!-- <a href="html/upload.jsp" ><button id="btn">Upload photos</button></a> -->

	
</body>
</html>
