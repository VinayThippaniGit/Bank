<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<% //System.out.println("Transfer Money.jsp  "+request.getSession().getAttribute("AccountDetails")); %>
	<jsp:include page="Header.jsp"></jsp:include>
	<jsp:include page="navAfterLogin.jsp"></jsp:include>
	<div class="container">
		<h1 style="text-align:center;">Transfer Money</h1>
		<form action="transferMoney" method="post">

			<div class="form-group">
				<label for="recipientAccount">Recipient's Account Number:</label> <input
					type="text" name="recipientAccountNumber" required>
			</div>
			<div class="form-group">
				<label for="amount">Amount:</label> <input type="number"
					name="amount" required min="1" step="1">
			</div>
			
			<button type="submit">Transfer</button>
		</form>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>