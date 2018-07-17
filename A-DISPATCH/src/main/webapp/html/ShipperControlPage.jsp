<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="
    com.amro.model.DTO.Shipper,
    com.amro.model.DAO.GetShipper" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Control Page</title>
<script>
    history.forward();
</script>
</head>
<body>
	<%
		if (request.getSession().getAttribute("user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("html/index.jsp");
			rd.forward(request, response);
		}
	%>
	<jsp:include page="shipperDashboardHeader.jsp" />

<h1>Shipper Control Page</h1>

<%
	Shipper shipper = GetShipper.getShipper((Integer)request.getSession().getAttribute("userID"));
%>
		<fieldset>
			<legend>Shipper Information</legend>
			<table>
				<tr>
					<th>First Name</th>
					<td><%=shipper.getFirstName()%></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><%=shipper.getLastName() %></td>
				</tr>
				<tr>
					<th>Phone</th>
					<td><%=shipper.getPhone() %>   </td>
				</tr>
				<tr>
					<th>E-mail</th>
					<td><%=shipper.getEmail() %></td>
				</tr>
				<tr>
					<th>Address</th>
					<td><%=shipper.getAddress() %></td>
				</tr>
				<tr>
					<th>City</th>
					<td><%=shipper.getCity() %></td>
				</tr>
				<tr>
					<th>State</th>
					<td><%=shipper.getState() %></td>
				</tr>
				<tr>
					<th>Zip Code</th>
					<td><%=shipper.getZipcode() %></td>
				</tr>
				<tr >
					<th> </th>
					<td rowspan="2"><a ><button >Edit Information</button></a></td>
				</tr>
		
			</table>
		</fieldset>
</body>
</html>