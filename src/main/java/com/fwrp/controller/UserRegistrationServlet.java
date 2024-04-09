package com.fwrp.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.fwrp.model.User;
import com.fwrp.dao.UserDAO;

@WebServlet("/register")
public class UserRegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract user details from the request
    	
        String action = request.getParameter("action");        
        
        if ("register".equals(action)) {
            String userName = request.getParameter("userName");
            String email = request.getParameter("email");
            String password = request.getParameter("password"); // Consider hashing the password before storing
            String userType = request.getParameter("userType");
            String favoriteIngredient = request.getParameter("favoriteIngredient");
            
         // Email Validation
            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                request.setAttribute("errorMessage", "Invalid email format");
                // Forward back to the registration form with an error message
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return; // Stop further execution to show the error
            }
            
            // Assuming User is a model class that encapsulates User properties
            User user = new User(userName, email, password, userType, favoriteIngredient);
            
            try {
                // UserDAO handles database operations
                UserDAO userDAO = new UserDAO();
                userDAO.addUser(user);
                
                // Redirect after successful registration
                response.sendRedirect("successfulRegistration.jsp");
            } catch (Exception e) {
                e.printStackTrace(); // Log the exception for debugging. Consider using a logging framework.

                // Set an error message attribute to be displayed on the registration page or an error page
                request.setAttribute("errorMessage", "Registration failed due to an internal error. Please try again.");

                // Forward to the registration page or a custom error page
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } else {
            // Handle other actions or error
            response.sendRedirect("register.jsp");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect GET requests to the registration form, or handle them as needed
        response.sendRedirect("register.jsp");
    }
}
