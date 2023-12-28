<%@page import="com.customer.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="edit" method="post">
<table>
 <% String email=request.getParameter("email");%>
 <% String first_name=request.getParameter("first_name");%>
 <% String last_name=request.getParameter("last_name");%>
 <% String street=request.getParameter("street");%>
 <% String address=request.getParameter("address");%>
 <% String city=request.getParameter("city");%>
 <% String state=request.getParameter("state");%>
 <% String phone=request.getParameter("phone");%>
 
<h1>Customer UUId:<%=email %></h1>
<h3>Updating customer details</h3>
            <tbody>
         
           <tr>
                <td>
                <label for="first_name">First Name:</label><br>
                <input type="text" id="first_name" name="first_name"  required value="<%=first_name %>">
                </td>
                <td>
                <label for="last_name">Last Name:</label><br>
                <input type="text" id="last_name" name="last_name" required value="<%=last_name %>"></td>
            </tr>
            <tr>
                <td><label for="street">Street:</label><br>
                <input type="text" id="street" name="street" value="<%=street %>"></td>
                 <td><label for="address"> Address:</label><br>
                <input type="text" id="address" name="address" value="<%=address %>"></td>
            </tr>
            <tr>
                <td><label for="city">City:</label><br>
                <input type="text" id="city" name="city" value="<%=city %>"></td>
                <td><label for="state">State:</label><br>
               <input type="text" id="state" name="state" value="<%=state %>"></td>
               </tr>
               <tr>
           
                  <td><label for="phone">Phone:</label><br>
                <input type="tele" id="phone" name="phone" value="<%=phone %>"></td>
                <td><input type="hidden" name="email" value="<%=email %>">
            </tr>
            </tbody>
        </table>
        <br>
        <input type="submit" value="Update">

</table>
</form>
</body>
</html>