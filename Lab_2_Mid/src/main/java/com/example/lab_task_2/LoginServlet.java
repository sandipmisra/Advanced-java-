package com.example.lab_task_2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection connection = DBUtil.getConnection();
                     PreparedStatement preparedStatement = connection.prepareStatement(
                     {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

           

            if (resultSet.next()) {
                String fullName = resultSet.getString("full_name");
                HttpSession session = request.getSession();
                session.setAttribute("fullName", fullName);
                response.sendRedirect("welcome.jsp");
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
