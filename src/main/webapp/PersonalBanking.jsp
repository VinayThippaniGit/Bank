<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.controller.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VM Bank - Login</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<jsp:include page="navAfterLogin.jsp"></jsp:include>
	    <div class="container data">
	    IFSC code : IFSC0001234	<br>
	   	Username : <% Account ac=(Account)request.getSession().getAttribute("AccountDetails"); %>
	   	<%= ac.getUsername().toUpperCase() %>	<br>
	   	Account Number : <%= ac.getAccid() %>	<br>
	   	<div id="vb" onclick="vb()">View balance : ₹ ---- </div>
	    </div>
	    
    <jsp:include page="Footer.jsp"></jsp:include>
    
    <script>
    
    	function vb(){
    		document.getElementById("vb").innerHTML="View balance : ₹" + <%= ac.getBalance() %> +".00" ;
    	}
    </script>
</body>
</html>