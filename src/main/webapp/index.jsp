<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
    p {
        text-align: right;
    }
    input {
        width: 100px;
    }
    </style>
</head>
<body>
<center><h1>WelCome to Shopping</h1>
<% if(request.getAttribute("information")==null){
		out.println("Please Enter the User Details");	
}else{
		out.println(request.getAttribute("information")+"Please Enter the correct User Details.");
}
%>
<form  method="POST" action ="LoginPage">

User Name :<input type="text" name="userName"><br>
Password  :<input type ="password" name ="password"><br>
            <input type="submit" value="login">

</form>
</center>
</body>
</html>
