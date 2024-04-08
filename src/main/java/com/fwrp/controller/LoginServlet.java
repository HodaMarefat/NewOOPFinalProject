package com.fwrp.controller;
import com.fwrp.model.User;
import com.fwrp.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        try {
            Optional<User> user = userService.loginUser(email, password);
            if (user.isPresent()) {
                // Login successful
                HttpSession session = request.getSession();
                session.setAttribute("user", user.get());
                response.sendRedirect(request.getContextPath() + "/home"); // Redirect to home or dashboard
            } else {
                // Login failed
                request.setAttribute("loginError", "Invalid email or password.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp"); // Redirect to an error page
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Optionally, you can handle GET request to show the login page
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}