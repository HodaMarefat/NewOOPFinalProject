package com.fwrp.controller;


import com.fwrp.dao.FoodItemDAO;
import com.fwrp.model.FoodItem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/foodItem")
public class FoodItemServlet extends HttpServlet {

    
    private FoodItemDAO foodItemDAO = new FoodItemDAO();
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
    	 	 
        List<FoodItem> foodItems = foodItemDAO.getAllFoodItems(); // Use DAO directly
        request.setAttribute("foodItems", foodItems); // Store the list in the request scope
        request.getRequestDispatcher("/foodItem.jsp").forward(request, response); // Forward to JSP
    }

}
