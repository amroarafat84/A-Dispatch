<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #999;
}

li {
    float: left;
}

li a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
li form {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
input{
	background-color: #999;
	border: 0;
	size: 13px;
	color: white;
}

li a:hover {
    background-color: #999;
}


</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
<script>
    history.forward();
</script>
</head>
<body>

	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	%>

	<%
		if (request.getSession().getAttribute("user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("html/index.jsp");
			rd.forward(request, response);
		}
	%>

<h1 align="center">Welcome to <dev style="color:red">${user}</dev> Dashboard</h1>

	<ul >
		<li><a href="/A-DISPATCH/ForwardToPostVehicle" class="active">Post Vehicle</a></li>
		
		<li><a href="/A-DISPATCH/ShipperVehicles">My Vehicles</a></li>

		<li ><a href="/A-DISPATCH/ShipperControlPage">Welcome: ${user}</a></li>
		
		<li><a href="/A-DISPATCH/Logout">Log out</a></li>

	</ul>

</body>
</html>