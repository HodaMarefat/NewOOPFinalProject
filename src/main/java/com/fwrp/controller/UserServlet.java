package com.fwrp.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet from Userservlet is called.");
    	// Forward to the JSP page
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Determine the type of form submission
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            // Process login
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Here, add your logic to validate the user...
            // If valid:
            HttpSession session = request.getSession();
            session.setAttribute("user", username); // Example of setting a session attribute
            // Redirect or forward as necessary
            response.sendRedirect("dashboard"); // Assuming there's a dashboard page
        } else if ("register".equals(action)) {
            // Process registration
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String userType = request.getParameter("userType");

            // Here, add your logic to register the user...
            // For example, save user info to the database

            // After registration, redirect or show a success message
            response.sendRedirect("login"); // Assuming you have a login page or section
        } else {
            // Invalid action
            response.sendRedirect("index.jsp");
        }
    }
}
