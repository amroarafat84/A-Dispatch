<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Post Vehicle</title>
</head>
<body>
	<%
		if (request.getSession().getAttribute("user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("html/index.jsp");
			rd.forward(request, response);
		}
	%>
	<jsp:include page="shipperDashboardHeader.jsp" />

<h1 align="center">Post Vehicle Page</h1>

<form>
	How many vehicles per load? <input type="text" name="number" size="5" pattern="[1-9]{1}" />
	<input type="submit" value="Add">
</form>

<%
	
	if(request.getParameter("number") != null){
		int num = Integer.parseInt(request.getParameter("number"));
		request.getSession().setAttribute("number", (Integer)num);
		out.print("You are shipping " + num + " vehicles.");
%>
<br>
<form action="/A-DISPATCH/HandlePostVehicle" method="post">
	<h4>Pick up information</h4>
		<br>Street Address: <input type="text" name="pickup_street" required> 
		<br>City: <input type="text" name="pickup_city" required> 
		State: <input type="text" name="pickup_state" size="4" min="2" maxlength="2" placeholder="State" 
								pattern="[A-Za-z]{2}" title="Two letters State code" required>
		ZipCode: <input type="text" name="pickup_zipCode" size="7" min="5" maxlength="5" 
				pattern="[0-9]{5}" placeholder="zipcode" required><br> 
		<h4>Drop off information</h4>
		<br>Street Address: <input type="text" name="dropoff_street" required> 
		<br>City: <input type="text" name="dropoff_city" required> 
		State: <input type="text" name="dropoff_state" size="4" min="2" maxlength="2" placeholder="State" 
								pattern="[A-Za-z]{2}" title="Two letters State code" required>
		ZipCode: <input type="text" name="dropoff_zipCode" size="7" min="5" maxlength="5" 
				pattern="[0-9]{5}" placeholder="zipcode" required><br> <br><br>
		Price: $<input type="text" name="price" " required><br>
		<%
			for(int i = 1 ; i <= num ; i++){
			%>
			<br>
			<%="Vehicle No: " + i %>
			<br>
			<select name="v_type">
			<option value="vehicle">Vehicle</option>
			<option value="motorcycle">MotorCycle</option>
			<option value="mobilehome">Mobilehome</option>
			</select>
			<br>
			<br>Year: <input type="text" name="year" pattern="[0-9]{4}"  maxlength="4" required>
			<br>Make: <input type="text" name="make" required>
			<br>Model: <input type="text" name="model" required>
			<br>Is Driveable: <input type="checkbox" name="driveable" value="y" >
			<br>
			<% 	
			}
		%>
		
		<br><input type="submit" value="Post">
		

</form>
<% 
	}
%>

</body>
</html>