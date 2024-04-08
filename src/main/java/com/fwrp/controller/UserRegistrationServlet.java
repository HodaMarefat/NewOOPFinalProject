package com.fwrp.controller;

import com.fwrp.model.User;
import com.fwrp.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerUser")
public class UserRegistrationServlet extends HttpServlet {

    private UserService userService = new UserService(); // Assume dependency injection or similar setup

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Extract user data from the request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");
        String favoriteIngredient = request.getParameter("favoriteIngredient");

        // Create a user object
        User newUser = new User();
        newUser.setUserName(name);
        newUser.setEmail(email);
        newUser.setPassword(password); // Note: Password should be hashed and checked for security
        newUser.setUserType(userType);
        newUser.setFavoriteIngredient(favoriteIngredient);

        // Attempt to register the user
        boolean isRegistered = userService.registerUser(newUser);

        // Determine the view based on the outcome
        if (isRegistered) {
            // Redirect or forward to a success page
            request.getRequestDispatcher("/registrationSuccess.jsp").forward(request, response);
        } else {
            // Redirect or forward to an error page or back to the registration form with an error message
            request.setAttribute("errorMessage", "User registration failed");
            request.getRequestDispatcher("/registrationForm.jsp").forward(request, response);
        }
    }
}
