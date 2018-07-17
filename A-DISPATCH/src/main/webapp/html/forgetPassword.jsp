<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forget Password</title>
</head>
<body>
<h2>Please fill in all the information </h2>
	<form action="/A-DISPATCH/ForgetPassword" method="post">
		<fieldset>
			<legend>Forget Password Page</legend>
			<br>User: <input type="text" name="user" placeholder="Use at least 5 characters" 
			 required>
			
			<br>Phone: <input type="text" placeholder="0000000000" name="phone" 
							   pattern="[0-9]{3}[0-9]{3}[0-9]{4}$" required> 
			
			<br>email: <input type="email" placeholder="email" name="email" required>
			
			<br><input type="submit" value="Submit">
		</fieldset>
	</form>
</body>
</html>