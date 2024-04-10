package com.fwrp.controller;

import com.fwrp.model.FoodItem;
import com.fwrp.service.RetailerService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/retail_updateFoodItem")
public class updateFoodItemServlet extends HttpServlet {
    private RetailerService retailerService = new RetailerService(); // Ensure this service is properly instantiated or injected

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String name = request.getParameter("name");
    	// if name is empty throw exception
    	// Check if name is empty or null
        if (name == null || name.trim().isEmpty()) {
            throw new ServletException("Name parameter is missing or empty");
        }
    	// from FoodItem DAO call: FoodItem FI = getFoodItemByName
        FoodItem foodItem = retailerService.getFoodItemByName(name);

    	// if FI is null throw exception
        if (foodItem == null) {
            throw new ServletException("No food item found with the name: " + name);
        }
    	
        try {
        	
        	// for each element of the request that is not null, update FI
            String description = request.getParameter("description");
            if (description != null && !description.trim().isEmpty()) {
                foodItem.setDescription(description);
            }

            String quantityStr = request.getParameter("quantity");
            if (quantityStr != null && !quantityStr.trim().isEmpty()) {
                int quantity = Integer.parseInt(quantityStr);
                foodItem.setQuantity(quantity);
            }

            String priceStr = request.getParameter("price");
            if (priceStr != null && !priceStr.trim().isEmpty()) {
                double price = Double.parseDouble(priceStr);
                foodItem.setPrice(price);
            }

            String expirationDateStr = request.getParameter("expirationDate");
            if (expirationDateStr != null && !expirationDateStr.trim().isEmpty()) {
                LocalDate expirationDate = LocalDate.parse(expirationDateStr);
                foodItem.setExpirationDate(expirationDate);
            }

            // Update the food item in the inventory through the RetailerService
            retailerService.updateFoodItem(foodItem); // Ensure you have a method to update items in your service

            // Set a success message to be displayed to the user
            request.getSession().setAttribute("message", "Food item updated successfully.");

            // Redirect to the success page
            response.sendRedirect("successfulUpdate.jsp");

        } catch (Exception e) {
            // Log the exception and set an error message for the user
            e.printStackTrace(); // Consider using a more robust logging approach
            request.getSession().setAttribute("error", "Failed to update the food item.");

            // Redirect back to the update food item form
            response.sendRedirect("retail_updateFoodItem.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect GET requests to the update form, or handle them as needed
        response.sendRedirect("retail_updateFoodItem.jsp");
    }
}
