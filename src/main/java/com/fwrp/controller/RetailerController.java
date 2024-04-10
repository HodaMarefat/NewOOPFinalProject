package com.fwrp.controller;

import com.fwrp.model.FoodItem;
import com.fwrp.service.RetailerService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/retailer/*")
public class RetailerController extends HttpServlet {

    private RetailerService retailerService = new RetailerService(); // Manually instantiate for simplicity
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        switch (action) {
	    	case "/addFoodItemForm":
	    		request.getRequestDispatcher("/retailer/addFoodItemForm.jsp").forward(request, response);
	    		break;
	    	case "/updateFoodItemForm":
	    		request.getRequestDispatcher("/retailer/updateFoodItemForm.jsp").forward(request, response);
	    		break;
	    	case "/listSurplusItemForm":
	    		request.getRequestDispatcher("/retailer/listSurplusItemForm.jsp").forward(request, response);	    		
	    		break;
	    	case "/markForDonationForm":
	    		request.getRequestDispatcher("/retailer/markForDonationForm.jsp").forward(request, response);	    		
	    		break;
	    	case "/markForSaleForm":
	    		request.getRequestDispatcher("/retailer/markForSaleForm.jsp").forward(request, response);	    		
	    		break;
	    		/*
            case "/inventory":
                getAllFoodItems(request, response);
                break;
            case "/deleteFoodItem":
                deleteFoodItem(request, response);
                break;
            case "/surplus":
                identifySurplusFoodItems(request, response);
                break;
                */
            default:
                // Handle default or unknown actions (e.g., redirect to an error page or log)
                break;
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        switch (action) {
            case "/addFoodItem":
                addFoodItem(request, response);
                break;
            case "/updateFoodItem":
                updateFoodItem(request, response);
                break;
            case "/listSurplusItem":
                listSurplusItem(request, response);
                break;
            case "/markForDonation":
                markItemForDonation(request, response);
                break;
            case "/markForSale":
                markItemForDiscountSale(request, response);
                break;
            default:
                // Handle default or unknown actions
                break;
        }
    }

    // Example method implementation
    private void getAllFoodItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int retailerId = Integer.parseInt(request.getParameter("retailerId"));
        List<FoodItem> foodItems = retailerService.getAllFoodItems(retailerId);
        request.setAttribute("foodItems", foodItems);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/inventory.jsp"); // Assuming you have a JSP page
        dispatcher.forward(request, response);
    }

    protected void deleteFoodItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract the food item ID from the request
        String idParam = request.getParameter("foodItemId");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int foodItemId = Integer.parseInt(idParam);
                retailerService.deleteFoodItem(foodItemId);
                
                // Set a success message to be displayed to the user
                request.getSession().setAttribute("message", "Food item deleted successfully.");
                
                // Redirect to the inventory page to show the updated list
                response.sendRedirect("inventory");
            } catch (NumberFormatException e) {
                // If the ID is not a valid integer, set an error message
                request.getSession().setAttribute("error", "Invalid food item ID.");
                
                // Redirect back to the inventory page or to an error page
                response.sendRedirect("inventory");
            }
        } else {
            // If no ID is provided, set an error message
            request.getSession().setAttribute("error", "No food item ID provided.");
            
            // Redirect back to the inventory page or to an error page
            response.sendRedirect("inventory");
        }
    }

    protected void identifySurplusFoodItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Assuming there's a way to get the retailerId from the session or request
        // For simplicity, let's say it's stored in the session.
        Integer retailerId = (Integer) request.getSession().getAttribute("retailerId");
        
        if (retailerId == null) {
            // Handle case where retailerId is not set, redirect to login or error page
            response.sendRedirect("login.jsp"); // Adjust as necessary
            return;
        }

        try {
            List<FoodItem> surplusFoodItems = retailerService.identifySurplusFoodItems(retailerId);
            request.setAttribute("surplusFoodItems", surplusFoodItems);
            
            // Forward to a JSP page to display the list of surplus food items
            RequestDispatcher dispatcher = request.getRequestDispatcher("/surplusFoodItemsDisplay.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            // Log the exception and potentially redirect to an error handling page
            e.printStackTrace(); // Consider logging the exception with a logging framework
            response.sendRedirect("errorPage.jsp"); // Adjust as necessary
        }
    }
    protected void addFoodItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract parameters from the request
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        LocalDate expirationDate = LocalDate.parse(request.getParameter("expirationDate")); // Ensure date is in 'YYYY-MM-DD' format

        // Create a new FoodItem object
        FoodItem foodItem = new FoodItem();
        foodItem.setFoodName(name);
        foodItem.setDescription(description);
        foodItem.setQuantity(quantity);
        foodItem.setExpirationDate(expirationDate);

        try {
            // Add the food item to the inventory through the RetailerService
            retailerService.addFoodItem(foodItem);

            // Optionally, set a success message to be displayed to the user
            request.getSession().setAttribute("message", "Food item added successfully.");

            // Redirect to the inventory page or a success page
            response.sendRedirect("inventory");
        } catch (Exception e) {
            // Handle exceptions, e.g., by logging them and setting an error message
            e.printStackTrace(); // Consider using a logging framework instead of printStackTrace()
            request.getSession().setAttribute("error", "Failed to add the food item.");

            // Redirect back to the add food item form or an error page
            response.sendRedirect("addFoodItemForm.jsp");
        }
    }
    
    protected void updateFoodItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Assuming the form includes food item ID, name, description, quantity, price, and expiration date
        int foodItemId = Integer.parseInt(request.getParameter("foodItemId"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        LocalDate expirationDate = LocalDate.parse(request.getParameter("expirationDate")); // Ensure the date is in 'YYYY-MM-DD' format

        FoodItem foodItem = new FoodItem();
        foodItem.setFoodItemId(foodItemId); // Assuming FoodItem class has setId method
        foodItem.setFoodName(name);
        foodItem.setDescription(description);
        foodItem.setQuantity(quantity);
        foodItem.setPrice(price);
        foodItem.setExpirationDate(expirationDate);

        try {
            retailerService.updateFoodItem(foodItem);

            // Optionally, set a success message to be displayed to the user
            request.getSession().setAttribute("message", "Food item updated successfully.");

            // Redirect to the inventory page or a success page
            response.sendRedirect("inventory");
        } catch (Exception e) {
            // Handle exceptions, e.g., by logging them and setting an error message
            request.getSession().setAttribute("error", "Failed to update the food item.");

            // Redirect back to the update food item form or an error page
            response.sendRedirect("updateFoodItemForm.jsp"); // Adjust the redirect URL as necessary
        }
    }
    
    protected void listSurplusItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract parameters from the request
        int foodItemId = Integer.parseInt(request.getParameter("foodItemId"));
        String status = request.getParameter("status"); // "forSale" or "forDonation"
        double discountRate = status.equals("forSale") ? Double.parseDouble(request.getParameter("discountRate")) : 0.0; // Discount rate applicable only if for sale

        try {
            if ("forSale".equals(status)) {
                // List the item for sale at the specified discount rate
                retailerService.markItemForDiscountSale(foodItemId, discountRate);
            } else if ("forDonation".equals(status)) {
                // Mark the item for donation
                retailerService.markItemForDonation(foodItemId);
            }

            // Optionally, set a success message to be displayed to the user
            request.getSession().setAttribute("message", "Food item listed as surplus successfully.");

            // Redirect to the inventory page or a success page
            response.sendRedirect("inventory.jsp"); // Adjust the redirect URL as necessary
        } catch (NumberFormatException e) {
            // Handle exceptions for number format issues
            request.getSession().setAttribute("error", "Invalid input.");
            response.sendRedirect("listSurplusItemForm.jsp"); // Redirect back to form
        } catch (Exception e) {
            // Handle other exceptions, e.g., by logging them and setting an error message
            request.getSession().setAttribute("error", "Failed to list the food item as surplus.");
            response.sendRedirect("listSurplusItemForm.jsp"); // Adjust the redirect URL as necessary
        }
    }
    
    protected void markItemForDonation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract the food item ID from the request
        int foodItemId;
        try {
            foodItemId = Integer.parseInt(request.getParameter("foodItemId"));
        } catch (NumberFormatException e) {
            // Handle the case where the food item ID is not a valid integer
            request.getSession().setAttribute("error", "Invalid food item ID.");
            response.sendRedirect("errorPage.jsp"); // Redirect to an error page
            return;
        }

        try {
            // Use the RetailerService to mark the item for donation
            retailerService.markItemForDonation(foodItemId);

            // Optionally, set a success message to be displayed to the user
            request.getSession().setAttribute("message", "Food item marked for donation successfully.");

            // Redirect to a confirmation page or back to the inventory page
            response.sendRedirect("inventoryPage.jsp"); // Adjust the redirect URL as necessary
        } catch (Exception e) {
            // Log the exception and set an error message for the user
            e.printStackTrace(); // Consider using a logging framework instead
            request.getSession().setAttribute("error", "Failed to mark the food item for donation.");
            
            // Redirect back to the donation form or an error page
            response.sendRedirect("donationForm.jsp"); // Adjust the redirect URL as necessary
        }
    }
    
    protected void markItemForDiscountSale(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract the food item ID and discount rate from the request
        int foodItemId;
        double discountRate;
        try {
            foodItemId = Integer.parseInt(request.getParameter("foodItemId"));
            discountRate = Double.parseDouble(request.getParameter("discountRate"));
        } catch (NumberFormatException e) {
            // Handle the case where parameters are not valid numbers
            request.getSession().setAttribute("error", "Invalid input for food item ID or discount rate.");
            response.sendRedirect("errorPage.jsp"); // Adjust the redirect URL as necessary
            return;
        }

        try {
            // Use the RetailerService to mark the item for discount sale
            retailerService.markItemForDiscountSale(foodItemId, discountRate);

            // Optionally, set a success message to be displayed to the user
            request.getSession().setAttribute("message", "Food item marked for discount sale successfully.");

            // Redirect to a confirmation page or back to the inventory page
            response.sendRedirect("inventoryPage.jsp"); // Adjust the redirect URL as necessary
        } catch (Exception e) {
            // Handle any exceptions by logging and setting an error message
            e.printStackTrace(); // Consider using a logging framework instead
            request.getSession().setAttribute("error", "Failed to mark the food item for discount sale.");
            
            // Redirect back to the form or an error page
            response.sendRedirect("saleForm.jsp"); // Adjust the redirect URL as necessary
        }
    }

}
