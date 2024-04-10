package com.fwrp.controller;

import com.fwrp.model.FoodItem;
import com.fwrp.service.RetailerService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/retailer/*")
public class RetailerController extends HttpServlet {

    private RetailerService retailerService = new RetailerService(); // Manually instantiate for simplicity

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        switch (action) {
            case "/inventory":
                getAllFoodItems(request, response);
                break;
            case "/deleteFoodItem":
                deleteFoodItem(request, response);
                break;
            case "/surplus":
                identifySurplusFoodItems(request, response);
                break;
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

    // Implement other methods (addFoodItem, updateFoodItem, etc.) similarly

    // Note: You'll need to adjust form actions and method calls in your JSPs accordingly
}
