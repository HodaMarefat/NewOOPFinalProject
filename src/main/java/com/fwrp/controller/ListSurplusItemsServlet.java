package com.fwrp.controller;

import com.fwrp.dao.FoodItemDAO;
import com.fwrp.model.FoodItem;
import com.fwrp.model.User;
import com.fwrp.service.RetailerService;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/retail_ListSurplusItem")
public class ListSurplusItemsServlet extends HttpServlet {
	
	private RetailerService retailerService = new RetailerService();
	private FoodItemDAO foodItemDAO = new FoodItemDAO();
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
		HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");	 
        int retailerId = user.getUserId();
		//List<FoodItem> surplusItems = retailerService.identifySurplusFoodItems(retailerId); 
		List<FoodItem> foodItems = foodItemDAO.getSurplusFoodItemsOfRetailer(retailerId);
        request.setAttribute("surplusItems", foodItems); // Store the list in the request scope
        request.getRequestDispatcher("/retail_ListSurplusItem.jsp").forward(request, response); // Forward to JSP
    }

}



