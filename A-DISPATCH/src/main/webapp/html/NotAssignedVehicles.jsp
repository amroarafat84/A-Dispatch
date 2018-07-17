<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,com.amro.model.DTO.Posts,java.util.Iterator,com.amro.model.DAO.LoadDAO,
    com.amro.model.DTO.Load,com.amro.model.DAO.PostDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Not Assigned Vehicles</title>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
</style>
</head>
<body>
	<jsp:include page="shipperDashboardHeader.jsp" />
	<br>
	<jsp:include page="ShipperMyvehicleHeader.jsp" />

	<table style="width: 100%">
		<tr>
			<th>Pickup Address</th>
			<th>DropOff Address</th>
			<th>Make</th>
			<th>Model</th>
			<th>Price</th>
		</tr>

		<%
		int count = 0;
		List<Posts> posts = PostDAO.getPost((Integer) request.getSession().getAttribute("userID"));
		for (Posts post : posts) {
			
			if (post.getAssigned() == 0) {
				count++;
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
			<td>$<%=post.getPrice() %></td>
		</tr>

		<%
			}

				}

			}
		%>
	</table>
	<% if(count != 0){ 
		%>
		<form method="post" action="/A-DISPATCH/AssignToCarrier" >
		<p align="center">
			<B>Assign To Carrier</B><br>
			Load ID: <input type="text" placeholder="Load ID" name="postid" required><br>
			Load Price: <input type="text" placeholder="Load Price" pattern="[0-9]+" name="price" required><br>
			Carrier ID: <input type="text" placeholder="Carrier number" name="carrierid" required><br>
			<input type="submit" value="Assign">
		</p>
	</form>
		<% 
	}%>
	


</body>
</html>