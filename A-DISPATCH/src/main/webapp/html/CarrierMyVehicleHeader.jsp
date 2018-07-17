<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Vehicles</title>
</head>
<body>

	<jsp:include page="CarrierHomePage.jsp" />
	<br>
	<div align="center">
		<ul >
		
		<li><a href="/A-DISPATCH/CarrierAssignedVehicles" class="active">Assigned</a></li>
		
		<li><a href="/A-DISPATCH/CarrierAcceptedVehicles">Accepted</a></li>

		<li ><a href="/A-DISPATCH/CarrierPickUpVehicles">Picked UP</a></li>
		
		<li><a href="/A-DISPATCH/CarrierDeliveredVehicle">Delivered</a></li>
		
		<li><a href="#">Canceled</a></li>

	</ul>
	
	</div>

</body>
</html>