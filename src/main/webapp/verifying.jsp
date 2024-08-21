<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.controller.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="styles.css">
</head>
<body>

	<jsp:include page="Header.jsp"></jsp:include>
	<%Account ac=(Account)request.getSession().getAttribute("AccountDetails");
	System.out.println("Verifying.jsp -> "+ac.getUsername()); %>
	<div class="container">
		<h1>Verify details</h1>
		<form action="verify" method="post">
			<div class="form-group">
				<label for="recipientAccount">Recipient's Account Number:</label> <input
					type="text" value="<%= request.getAttribute("recipientAccountNumber") %>" id="recipientAccountNumber" name="recipientAccountNumber" readonly="readonly" >
			</div>
			<div class="form-group">
				<label for="amount">Amount:</label> <input type="number" id="amount"
					name="amount" value="<%= request.getAttribute("amount") %>" min="0.01" step="0.01" readonly="readonly" >
			</div>
			<div class="form-group">
				<label for="Name">Account Holder's Name</label>
				<input type="text" value="<%= request.getAttribute("recipientName") %>" id="name" name="name" readonly="readonly" >
			</div>
			<div class="form-group">
				<label for="password">Enter your password</label>
				<input type="password" name="password" >
			</div>
			
			<button style="background-color:green" type="submit">Verify</button>
			<br><br>
		</form>
		<a href="transferMoney.jsp"><button style="background-color:red;text-decoration:none">Details not Matched! Go Back</button></a>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>