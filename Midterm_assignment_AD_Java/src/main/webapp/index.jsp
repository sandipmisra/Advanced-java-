<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leave Calculator</title>
</head>
<body>
<div class="container">
    <h2>Leave Calculator</h2>
    <form action="LeaveCalculatorServlet" method="post">
        <label for="employeeType">Employee Type:</label>
        <select name="employeeType" id="employeeType">
            <option value="Staff">Staff</option>
            <option value="Officer">Officer</option>
        </select>

        <label for="joiningDate">Joining Date (yyyy-MM-dd):</label>
        <input type="text" name="joiningDate" id="joiningDate" required>

        <input type="submit" value="Calculate Leave">
    </form>
</div>
</body>
</html>
