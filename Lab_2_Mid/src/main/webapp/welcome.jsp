<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Welcome</title>
  
</head>
<body>
<div class="welcome-container">
  <h2>Welcome, ${fullName}!</h2>
  <p>
    Thank you for using our application.
  </p>
  <ul>
    <li><a href="LogoutServlet" class="logout-btn">Logout</a></li>
  </ul>
</div>
</body>
</html>
