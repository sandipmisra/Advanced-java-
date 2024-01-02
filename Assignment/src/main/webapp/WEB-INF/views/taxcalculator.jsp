<%--
  Created by IntelliJ IDEA.
  User: apurbadebnath
  Date: 31/12/23
  Time: 12:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tax Calculator</title>
    <style>

    </style>
</head>
<body>
<h2>Tax Calculator</h2>
<form action="calculateTax" method="post">
    <label for="category">Category:</label>
    <select name="category" id="category">
        <option value="Male">Male</option>
        <option value="Female">Female</option>
        <option value="Especially Abled">Specially Abled</option>
        <option value="Freedom Fighter">Freedom Fighter</option>
        <!-- Add more options as needed -->
    </select><br>

    <label for="totalIncome">Total Income:</label>
    <input type="number" id="totalIncome" name="totalIncome" required><br>

    <button type="submit">Calculate Tax</button>

    
</form>
</body>
</html>


