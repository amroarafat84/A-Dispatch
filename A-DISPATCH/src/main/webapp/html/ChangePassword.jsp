<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
</head>
<body>
	<%
		if (session.getAttribute("userId") == null) {
			response.sendRedirect("/html/index.jsp");
		}
	%>
	<% 
	response.setHeader( "Pragma", "no-cache" );
	response.setHeader( "Cache-Control", "no-cache" );
	response.setDateHeader( "Expires", 0 );
	%>
	<form action="ChangePassword" method="post">
		<fieldset>
			<legend>Change Password Page</legend>
			<br>New Password: <input type="password" name="new_password" placeholder="Use at least 5 characters" 
					 min="5" title="Please use: a-zA-Z0-9._%+&-" required>
			<br> Confirm Password: <input type="password" name="confirm_password" placeholder="Use at least 5 characters" 
					 min="5" title="Please use: a-zA-Z0-9._%+&-" required>
			<input type="submit" value="Submit">
		</fieldset>
	</form>
</body>
</html>