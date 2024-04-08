package com.fwrp.controller;
import java.util.logging.Logger;

import com.fwrp.dao.FoodItemDAO;
import com.fwrp.model.FoodItem;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/foodItems")
public class FoodItemsServlet extends HttpServlet {
	


	private final static Logger LOGGER = Logger.getLogger(FoodItemsServlet.class.getName());

    
    private FoodItemDAO foodItemDAO = new FoodItemDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	LOGGER.info("Fetching food items from database...");
    	System.out.println("Printing command: Fetching food items from database...");
    	 
        List<FoodItem> foodItems = foodItemDAO.getAllFoodItems(); // Use DAO directly
        request.setAttribute("foodItems", foodItems); // Store the list in the request scope
        request.getRequestDispatcher("/foodItem.jsp").forward(request, response); // Forward to JSP
    }
}
