<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles.css">
</head>
<body>

	<nav>
		<ul>
			<li><a href="loginPage.jsp">Home</a></li>
			<li><a href="transferMoney.jsp">Transfer Money</a></li>
			<li><a href="#services">Services</a></li>
			<li><a href="#contact">Contact</a></li>
		</ul>
		<div class="logout" onclick="logout()">logout</div>
	</nav>
	<script>
		function logout(){
			if(confirm("Do you want to logout")==true){
				window.location.href="index.jsp";
			}
		}
	</script>
</body>
</html>