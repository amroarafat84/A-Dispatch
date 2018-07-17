<!DOCTYPE html>
<%@ page import="com.amro.model.DAO.Authentication" %>
<html>
<head>
<meta charset="UTF-8">
<title>Shipper Sign Up</title>
</head>
<body>
	<h2>Shipper Sign up</h2>
	<form action="/A-DISPATCH/ShipperSignUp" method="post">
		<fieldset>
			<legend>Shipper Application</legend>
			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName" placeholder="First name" required></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><input type="text" placeholder="Last Name" name="lastName" required> </td>
				</tr>
				<tr>
					<th>Phone</th>
					<td><input type="text" placeholder="0000000000" name="phone" 
							   pattern="[0-9]{3}[0-9]{3}[0-9]{4}$" required></td>
				</tr>
				<tr>
					<th>E-mail</th>
					<td><input type="email" placeholder="email" name="email" required></td>
				</tr>
				<tr>
					<th>Address</th>
					<td><input type="text" name="address" placeholder="Address" required></td>
				</tr>
				<tr>
					<th>City</th>
					<td><input type="text" name="city" placeholder="City" required></td>
				</tr>
				<tr>
					<th>State</th>
					<td><input type="text" name="state" size="4" min="2" maxlength="2" placeholder="State" 
								pattern="[A-Za-z]{2}" title="Two letters State code" required></td>
				</tr>
				<tr>
					<th>Zip Code</th>
					<td><input type="text" name="zipCode" size="7" min="5" maxlength="5" 
				pattern="[0-9]{5}" placeholder="zipcode" required></td>
				</tr>
				<tr>
					<th>User Name</th>
					<td><input type="text" name="user" placeholder="Use at least 5 characters" min="5" required> 
			<% Authentication auth = new Authentication();
				int i = auth.authenticateUser(request.getParameter("user"));
				if(i == 1)
					out.print("Invalid user name");
			%></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" placeholder="Use at least 5 characters" 
								min="5" required> </td>
				</tr>
				<tr>
					<td ></td>
					<td><input type="submit" value="Submit" ></td>
				</tr>			
			</table>
		</fieldset>
	</form>

</body>
</html>