package com.fwrp.service;

import com.fwrp.dao.FoodItemDAO;
import com.fwrp.dao.TransactionDAO;
import com.fwrp.model.FoodItem;
import com.fwrp.model.Transaction;
import com.fwrp.model.User;

public class ConsumerService {
    private FoodItemDAO foodItemDAO;
    private TransactionDAO transactionDAO;

    public ConsumerService() {
        this.foodItemDAO = new FoodItemDAO(); // Dependency Injection is recommended
        this.transactionDAO = new TransactionDAO();
    }

    // Method for consumers to purchase an item
    public boolean purchaseItem(int userId, int foodItemId, int quantity) {
        FoodItem foodItem = foodItemDAO.getFoodItemById(foodItemId);
        
        // Check if the item is available for purchase
        if (foodItem != null && foodItem.getQuantity() >= quantity) {
            // Deduct the quantity from inventory
            foodItem.setQuantity(foodItem.getQuantity() - quantity);
            foodItemDAO.updateFoodItem(foodItem);
            
            // Record the transaction (not a real financial transaction)
            Transaction transaction = new Transaction();
            
            User user = new User();
            user.setUserId(userId);
            transaction.setBuyer(user);

            transaction.setFoodItem(foodItem);
            transaction.setQuantity(quantity);
            transactionDAO.addTransaction(transaction);

            return true; // Purchase was successful
        } else {
            return false; // Item not available for the requested quantity
        }
    }

    // Method to update inventory after purchase (could be integrated in purchaseItem method)
    // Note: This functionality is shown as part of the purchaseItem method.
    
    // Additional consumer-related functionalities
}
