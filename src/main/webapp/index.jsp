<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<!-- for jstl tag -->
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!-- end of jstl tag -->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>VM Bank</title>
<link rel="stylesheet" href="styles.css">
<!-- Link to an external CSS file -->
<script>
		window.history.forward();
	</script>
</head>
<body>
	<%request.getSession().removeAttribute("AccountDetails"); %>
	<jsp:include page="Header.jsp"></jsp:include>
	<jsp:include page="navBeforeLogin.jsp"></jsp:include>
	<div class="login-container">
		<form action="login" method="post">
			<input type="text" id="accid" name="accid"
				placeholder="Account number" required> <input
				type="password" id="password" name="password" placeholder="Password"
				required>
			<button type="submit">Login</button>
		</form>
		<p class="btn" onclick="window.location.href='ForgotPassword.jsp'">Forgot
			your password?</p>

	</div>
	<jsp:include page="Footer.jsp"></jsp:include>

	
</body>

</html>
