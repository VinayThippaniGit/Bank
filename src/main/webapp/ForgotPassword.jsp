<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VM Bank - Reset Password</title>
    <link rel="stylesheet" href="styles.css">
    <script defer src="script.js"></script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="navBeforeLogin.jsp"></jsp:include>
    
    <div class="container">
        
        <h2>Reset Your Password</h2>
        <p>Please confirm your details to reset your password.</p>
        <form id="reset-password-form" action="ResetPassword" method="post">
                
                Email:<input type="email" id="email" name="email" required><br>
               	Username:<input type="text" id="username" name="username" required><br>
                Date of Birth:<input type="date" id="dob" name="dob" placeholder="Dob" required><br>
                New Password:<input type="password" id="new_password" name="new_password" required><br>
                Confirm New Password:<input type="password" id="confirm_password" name="password" required>
            <div id="error-message" class="error-message"></div>
            <button type="submit">Reset Password</button>
        </form>
    </div>
    <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
