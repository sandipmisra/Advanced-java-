package com.example.lab_task_2;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebFilter("/welcome.jsp")
public class AuthenticationFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
       
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);

       
    }

    public void destroy() {
       
    }
}

