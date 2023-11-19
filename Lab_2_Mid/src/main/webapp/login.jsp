<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>User Login</title>
  
</head>
<body>
<div class="login-container">
  <h2>User Login</h2>
  <form action="LoginServlet" method="post">
    <label>Email:</label>
    <input type="email" name="email" required>

    <label>Password:</label>
    <input type="password" name="password" required>

    <input type="submit" value="Login">
  </form>
</div>
</body>
</html>
