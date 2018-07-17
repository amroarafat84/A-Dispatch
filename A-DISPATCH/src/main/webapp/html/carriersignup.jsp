<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrier Sign up</title>
</head>
<body>
	<h2>Carrier Sign up</h2>
	<form action="/A-DISPATCH/CarrierSignUp" method="post" >
			<fieldset>
			<legend>Carrier Application</legend>
		<br>First Name: <input type="text" name="firstName" required> 
		
		<br>Last Name: <input type="text" name="lastName" required> 
		
		<br>Company Name: <input type="text" name="companyName" required>
		
		<br>phone: <input type="text" placeholder="0000000000" name="phone" 
							   pattern="[0-9]{3}[0-9]{3}[0-9]{4}$" required> 
		
		<br>email: <input type="email" placeholder="email" name="email" 
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required>
		
		<br>Street Address: <input type="text" name="address" required> 
			
		<br>City: <input type="text" name="city" required> 
		
		State: <input type="text" name="state" size="4" min="2" maxlength="2" placeholder="State" 
								pattern="[A-Za-z]{2}" title="Two letters State code" required>
		
		ZipCode: <input type="text" name="zipCode" size="7" min="5" maxlength="5" 
				pattern="[0-9]{5}" placeholder="zipcode" required>  
				
		<br>Federal ID: <input type="text" name="federalId" placeholder="12-3456789" pattern="[0-9]{2}-[0-9]{7}$" required> 
		
		<br>Insurance Policy: <input type="text" name="insurancePolicy" required> 
		
		<br>Insurance Expiration Date: <input type="date" name="expiration" placeholder="YYYY-MM-DD" required> 
		
		<br><br>User Name: <input type="text" name="user" placeholder="Use at least 5 characters" min="5" required> <br>
		
		<br>Password: <input type="password" name="password" placeholder="Use at least 5 characters" 
								min="5" required> 
								
		<input type="button" onclick="alert('Hello World!')" value="Click Me!"> 
		
		<br><input type="submit" value="submit">
			</fieldset>
	</form>
</body>
</html>