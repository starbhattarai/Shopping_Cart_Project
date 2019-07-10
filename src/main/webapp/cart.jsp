<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Details</title>
</head>
<body>
<% response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("userName")==null){
	response.sendRedirect("index.jsp");
}%>
<%= "Hello "+ session.getAttribute("userName") %>
<jsp:include page="logout.jsp"/>
<h2>Cart Detail is:</h2><br>
<table border="1" style ="width:400px">
<tr>
<th width="100"><b>itemId</b></th>
<th width="300"><b>itemName</b></th>
<th width="200"><b>itemPrice</b></th>
<th width="100"><b>itemQuantity</b></th>
<th width="300"><b>itemImage</b></th>
</tr>
<% List cartData = (List)request.getAttribute("cartData");
Iterator itr=cartData.iterator(); 
int totalPrice=0;
int totalQuantity = 0;
while(itr.hasNext()){
	%>
	<tr>
	<td width="100"><%= itr.next() %></td>
	<td width="300"><%= itr.next() %></td>
	<%int itemPrice = (int)itr.next(); 
	%>
	<td width="200"><%= itemPrice %></td>
	<%int itemQuantity = (int)itr.next(); 
	totalQuantity+=itemQuantity;
	totalPrice+=itemPrice*itemQuantity;
	%>
	<td width="100"><%= itemQuantity %></td>
	<td width="300"><%= itr.next() %></td>
	<td width="300">
	</td>
	</tr>
<% } %>
<tr>
<th width="100"><b>Total</b></th>
<th width="300"><b></b></th>
<th width="200"><b><%=totalPrice%></b></th>
<th width="100"><b><%=totalQuantity%></b></th>
<th width="300"><b></b></th>
<th width="300">
<form name="checkout" method="POST" action="CheckOut">
		<input type="submit" value="CheckOut">
</form>
</th>
</tr>
</table>
<form name="Back" method="POST" action="LoginPage">
		<input type="hidden" name="userName" value=<%=session.getAttribute("userName")%> >
		<input type="hidden" name="password" value=<%=session.getAttribute("password")%> >
		<input type="submit" value=" Get more items ">
	</form>
</body>
</html>