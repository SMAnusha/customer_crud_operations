<%@page import="com.customer.dto.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
td,th{
text-align:center;
}


</style>
</head>
<body>
	<a href="CustomerCreate.html"><input type="button" value="Add customer"></a>
	<table border="">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Street</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Customer> list = (List<Customer>) request.getAttribute("data");
				for (Customer customer : list) {
			%>
			<tr>
				<td><%=customer.getFirst_name()%></td>
				<td><%=customer.getLast_name()%></td>
				<td><%=customer.getStreet()%></td>
				<td><%=customer.getAddress()%></td>
				<td><%=customer.getCity()%></td>
				<td><%=customer.getState()%></td>
				<td><%=customer.getEmail()%></td>
				<td><%=customer.getPhone()%></td>
				<td>
					<form action="delete" method="post">
						<input type="hidden" name="email" value="<%=customer.getEmail()%>">
						<button>
						<img src="delete.png" width="20px" height="20px">
						</button>
					</form>
				<form action="customerEdit.jsp">
	<input type="hidden" name="email" value="<%=customer.getEmail()%>">
	<input type="hidden" name="first_name" value="<%=customer.getFirst_name()%>">
	<input type="hidden" name="last_name" value="<%=customer.getLast_name()%>">
	<input type="hidden" name="street" value="<%=customer.getStreet()%>">
	<input type="hidden" name="state" value="<%=customer.getState()%>">
	<input type="hidden" name="address" value="<%=customer.getAddress()%>">
	<input type="hidden" name="city" value="<%=customer.getCity()%>">
	<input type="hidden" name="phone" value="<%=customer.getPhone()%>">
	<button><img src="edit.png" width="20px" height="20px" alt="Edit"></button>
	</form>
	</td>
					<% } %> 
				</tr>
		</tbody>

	</table><br>
	<a href="login.html"><input type="button" value="Logout"></a>
</body>
</html>