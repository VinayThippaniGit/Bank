<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.service.LoginCheck"%>
<%@page import="com.controller.Account"%>
<%
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0"); //prevents caching at the proxy server
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>VM Bank - Dashboard</title>
<script>
	window.history.forward();
</script>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<jsp:include page="navAfterLogin.jsp"></jsp:include>
	<%Account ac = (Account) request.getSession().getAttribute("AccountDetails");
		%>

	<section class="hero">
		<h1>Welcome to VM Bank</h1>
		<h3 style="color: blue">
			Account holder name : <%= ac.getUsername().toUpperCase() %>
		</h3>
		<p>Your trusted partner for all financial needs. Experience
			seamless banking with us.</p>
		<p>Explore the below services provided by our bank for best user
			experience</p>

	</section>

	<section class="features" id="services">
		<div class="feature"
			onclick="window.location.href='PersonalBanking.jsp'">
			<h3>Personal Banking</h3>
			<p>Manage your personal accounts with ease. Access a range of
				banking services tailored for you.</p>
		</div>
		<div class="feature">
			<h3>Business Banking</h3>
			<p>Discover our business solutions designed to help you grow and
				manage your company finances.</p>
		</div>
		<div class="feature">
			<h3>Online Services</h3>
			<p>Bank from anywhere with our secure and user-friendly online
				banking platform.</p>
		</div>
	</section>


	<jsp:include page="Footer.jsp"></jsp:include></html>
