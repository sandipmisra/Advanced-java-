package com.example.mid_assignment;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/LeaveCalculatorServlet")
public class LeaveCalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String employeeType = request.getParameter("employeeType");
        String joiningDate = request.getParameter("joiningDate");

        request.setAttribute("employeeType", employeeType);
        request.setAttribute("joiningDate", joiningDate);

        calculateLeave(request);

        request.getRequestDispatcher("leaveResult.jsp").forward(request, response);
    }

    private void calculateLeave(HttpServletRequest request) {
        String employeeType = request.getParameter("employeeType");
        String joiningDate = request.getParameter("joiningDate");

        Employee employee = (employeeType.equalsIgnoreCase("Staff"))
                ? new Employee("Staff", 10, 7)
                : new Employee("Officer", 15, 10);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date joinDate = dateFormat.parse(joiningDate);
            Date endDateOfYear = dateFormat.parse("2023-12-31");

            int totalDaysInYear = isLeapYear(2023) ? 366 : 365;

            long totalDays = ((endDateOfYear.getTime() - joinDate.getTime()) / (24 * 60 * 60 * 1000)) + 1;

            double vacationLeaveDays = calculateLeaveDays(totalDays, employee.vacationLeave, totalDaysInYear);
            double sickLeaveDays = calculateLeaveDays(totalDays, employee.sickLeave, totalDaysInYear);

            request.setAttribute("vacationLeave", (int) vacationLeaveDays);
            request.setAttribute("sickLeave", (int) sickLeaveDays);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private double calculateLeaveDays(long totalDays, int leaveDays, int totalDaysInYear) {
        double leave = (totalDays * leaveDays) / totalDaysInYear;
        return (leave < 0.5) ? Math.floor(leave) : Math.ceil(leave);
    }

}
