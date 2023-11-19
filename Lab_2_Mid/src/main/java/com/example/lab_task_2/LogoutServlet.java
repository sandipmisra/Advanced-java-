package com.example.lab_task_2;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Perform logout operations, such as invalidating the session
        request.getSession().invalidate();

        // Redirect the user to the login page or any other appropriate page
        response.sendRedirect("index.jsp");
    }
}

