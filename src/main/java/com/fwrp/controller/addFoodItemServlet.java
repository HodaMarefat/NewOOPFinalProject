package com.fwrp.controller;
import com.fwrp.model.FoodItem;
import com.fwrp.model.User;
import com.fwrp.service.RetailerService;
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
import java.time.LocalDate;
import java.util.Optional;

@WebServlet("/retail_addFoodItem")
public class addFoodItemServlet extends HttpServlet {
	private RetailerService retailerService = new RetailerService(); // Manually instantiate for simplicity
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract parameters from the request
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        LocalDate expirationDate = LocalDate.parse(request.getParameter("expirationDate")); // Ensure date is in 'YYYY-MM-DD' format
      
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            
            
            
            
            // Create a new FoodItem object
            FoodItem foodItem = new FoodItem();
            
            foodItem.setFoodName(name);
            foodItem.setDescription(description);
            foodItem.setQuantity(quantity);
            foodItem.setPrice(price);
            foodItem.setExpirationDate(expirationDate);
            foodItem.setRetailerId(user.getUserId());

            // Add the food item to the inventory through the RetailerService
            retailerService.addFoodItem(foodItem);

            // Optionally, set a success message to be displayed to the user
            request.getSession().setAttribute("message", "Food item added successfully.");

        	// Redirect to the success page
            response.sendRedirect("successfulAddedItem.jsp");

        } catch (Exception e) {
            // Handle exceptions, e.g., by logging them and setting an error message
            e.printStackTrace(); // Consider using a logging framework instead of printStackTrace()
            request.getSession().setAttribute("error", "Failed to add the food item.");

            // Redirect back to the add food item form or an error page
            response.sendRedirect("addFoodItemForm.jsp");
        }
	}
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect GET requests to the registration form, or handle them as needed
        response.sendRedirect("retail_addFoodItem.jsp");
    }
}