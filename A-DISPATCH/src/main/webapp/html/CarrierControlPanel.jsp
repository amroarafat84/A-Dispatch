<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="
    com.amro.model.DTO.Carrier,
    com.amro.model.DAO.GetCarrier" %>
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
	<jsp:include page="CarrierHomePage.jsp" />

<h1>Carrier Control Page</h1>

<%
	Carrier carrier = GetCarrier.getCarridByID((Integer)request.getSession().getAttribute("userID"));
%>
		<fieldset>
			<legend>Carrier Information</legend>
			<table>
				<tr>
					<th>First Name</th>
					<td><%=carrier.getFirstName()%></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><%=carrier.getLastName() %></td>
				</tr>
				<tr>
					<th>Company Name</th>
					<td><%=carrier.getCompanyName() %></td>
				</tr>
				<tr>
					<th>Company Code</th>
					<td><%=carrier.getId() %></td>
				</tr>
				<tr>
					<th>Phone</th>
					<td><%=carrier.getPhone() %>   </td>
				</tr>
				<tr>
					<th>E-mail</th>
					<td><%=carrier.getEmail() %></td>
				</tr>
				<tr>
					<th>Address</th>
					<td><%=carrier.getAddress() %></td>
				</tr>
				<tr>
					<th>City</th>
					<td><%=carrier.getCity() %></td>
				</tr>
				<tr>
					<th>State</th>
					<td><%=carrier.getState() %></td>
				</tr>
				<tr>
					<th>Zip Code</th>
					<td><%=carrier.getZipcode() %></td>
				</tr>
				<tr >
					<th> </th>
					<td rowspan="2"><a ><button >Edit Information</button></a></td>
				</tr>
		
			</table>
		</fieldset>
</body>
</html>