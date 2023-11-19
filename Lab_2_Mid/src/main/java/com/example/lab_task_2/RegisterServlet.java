package com.example.lab_task_2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");

        try (Connection connection = DBUtil.getConnection();
                     PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO users (email, full_name, password) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, fullName);
            preparedStatement.setString(3, password);
           

            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
