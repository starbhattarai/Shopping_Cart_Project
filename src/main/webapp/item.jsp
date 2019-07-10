<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Details</title>
</head>
<body>
<% response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
if(session.getAttribute("userName")==null){
	response.sendRedirect("index.jsp");
}%>
<%= "Hello "+ session.getAttribute("userName") %>
<jsp:include page="logout.jsp"/>
<h2>Items Detail is:</h2><br>
<table border="1" style ="width:400px">
<tr>
<th width="100"><b>itemId</b></th>
<th width="300"><b>itemName</b></th>
<th width="200"><b>itemPrice</b></th>
<th width="100"><b>itemQuantity</b></th>
<th width="300"><b>itemImage</b></th>
<th width="300"><b>Add to Cart</b></th>
</tr>
<% List itemData = (List)request.getAttribute("itemData");
Iterator itr=itemData.iterator();
while(itr.hasNext()){
	%>
	<tr>
	<%int itemId = (int)itr.next(); %>
	<td width="100"><%= itemId  %></td>
	<%String itemName = (String)itr.next(); %>
	<td width="300"><%= itemName %></td>
	<%int itemPrice = (int)itr.next(); %>
	<td width="200"><%= itemPrice %></td>
	<%int itemQuantity = (int)itr.next(); %>
	<td width="100"><%= itemQuantity %></td>
	<%String itemImage = (String)itr.next(); %>
	<td width="300"><%= itemImage %></td>
	<td width="300">
	<form  method="POST" action="AddToCart">
		<input type="hidden" name="itemId" value=<%=itemId%> >
		<input type="hidden" name="itemName" value=<%=itemName%> >
		<input type="hidden" name="itemPrice" value=<%=itemPrice%> >
		<input type="hidden" name="itemQuantity" value=<%=itemQuantity%> >
		<input type="hidden" name="itemImage" value=<%=itemImage%> >
		<input type="submit" value="Add to Cart">
	</form>
	</td>
	</tr>
<% } %>
</table>
</body>
</html>