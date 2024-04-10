package com.fwrp.controller;
import com.fwrp.model.User;
import com.fwrp.dao.UserDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String email = request.getParameter("email"); 
	    String password = request.getParameter("password");
	    
	    UserDAO userDao = new UserDAO(); // a UserDAO for DB operations
	    
	    try {
	        Optional<User> optionalUser = userDao.findUserByEmail(email);
	        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)) {
	            // Successful login
	            HttpSession session = request.getSession();
	            session.setAttribute("user", optionalUser.get());
	            //int userId = optionalUser.get().getUserId();
	           
                
                // Redirect based on user type
                switch (optionalUser.get().getUserType()) {
                    case "Retailer":
                        response.sendRedirect("retailer.jsp"); // Replace "retailerPage.jsp" with the actual page for retailers
                        break;
                    case "Consumer":
                        response.sendRedirect("consumer.jsp"); // Replace "consumerPage.jsp" with the actual page for consumers
                        break;
                    case "CharityOrganization":
                        response.sendRedirect("charityOrganization.jsp"); // Replace "charityOrganizationPage.jsp" with the actual page for charity organizations
                        break;
                    default:
                        response.sendRedirect("welcome.jsp"); // Default redirect if user type doesn't match
                        break;
                }
	        } else {
	            // Failed login
	            request.setAttribute("loginError", "Invalid username or password");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	            dispatcher.forward(request, response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace(); // Better error handling recommended
	    }
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect GET requests to the registration form, or handle them as needed
        response.sendRedirect("login.jsp");
    }

}