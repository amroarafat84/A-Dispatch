<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shipper Vehicles</title>
</head>
<body>
	<%
		if (request.getSession().getAttribute("user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("html/index.jsp");
			rd.forward(request, response);
		}
	%>
	<jsp:include page="shipperDashboardHeader.jsp" />
	
	<br>
	
	
	<jsp:include page="ShipperMyvehicleHeader.jsp" />
<h1>Shipper Vehicles</h1>
</body>
</html>