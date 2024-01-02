<%--
  Created by IntelliJ IDEA.
  User: apurbadebnath
  Date: 31/12/23
  Time: 12:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tax Calculation Result</title>
    <style>

    </style>
</head>
<body>

<h3>Income Breakdown:</h3>
<p>Basic Pay: ${basicPay}</p>
<p>House Rent: ${houseRent}</p>
<p>Medical Allowance: ${medicalAllowance}</p>
<p>Conveyance Allowance: ${conveyanceAllowance}</p>
<p>Bonus: ${bonus}</p>

<h3>Tax Calculation Result</h3>

<p>Category: ${category}</p>
<p>Total Income: ${totalIncome}</p>
<p>Calculated Tax: ${calculatedTax}</p>

<a href="${pageContext.request.contextPath}/taxcalculator">
    <button type="button">Calculate Tax</button>
</a>

</body>
</html>

