<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.amro.model.DTO.Posts,java.util.Iterator,com.amro.model.DAO.LoadDAO,
    com.amro.model.DTO.Load,com.amro.model.DAO.PostDAO,com.amro.model.DTO.Carrier,com.amro.model.DAO.GetCarrier" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accepted Vehicles</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
</style>
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
	
		<table style="width: 100%">
		<tr>
			<th>Pickup Address</th>
			<th>DropOff Address</th>
			<th>Make</th>
			<th>Make</th>
			<th>Carrier</th>
		</tr>

		<%
		List<Posts> posts = PostDAO.getPost((Integer) request.getSession().getAttribute("userID"));
		Carrier carrier = new Carrier();
		for (Posts post : posts) {
			if (post.getAccepted() == 1 && post.getPickedup() == 0) {
				carrier = GetCarrier.getCarridByID(post.getCarrierId());
				%>
		<tr>
			<td align="center" bgcolor="#79b6e3" colspan="5">Load ID. <%=post.getPostId() %></td>
		</tr>
		<%
				List<Load> loads = LoadDAO.getLoad(post.getPostId());
	 			for(Load load : loads){
	 	%>
		<tr>
			<td><%=post.getPickupCity()+", "+post.getPickupState() %></td>
			<td><%=post.getDropoffCity()+", "+post.getDropoffState() %></td>
			<td><%=load.getMake() %></td>
			<td><%=load.getModel() %></td>
			<td><%=carrier.getCompanyName()+ "--" + carrier.getPhone()  %></td>
		</tr>

		<%
			}

				}

			}
		%>
	</table>

</body>
</html>