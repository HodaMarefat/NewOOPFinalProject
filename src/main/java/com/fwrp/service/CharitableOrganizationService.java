package com.fwrp.service;

import com.fwrp.dao.FoodItemDAO;
import com.fwrp.model.FoodItem;

public class CharitableOrganizationService {
    private FoodItemDAO foodItemDAO;

    public CharitableOrganizationService() {
        this.foodItemDAO = new FoodItemDAO(); // Ideally, use dependency injection
    }

    // Method for a charitable organization to claim a food item
    public boolean claimFoodItem(int foodItemId) {
        // Retrieve the food item to be claimed
        FoodItem foodItem = foodItemDAO.getFoodItemById(foodItemId);
        
        if (foodItem != null && "Available".equals(foodItem.getStatus())) {
            // Mark the food item as claimed and update it in the database
            foodItem.setStatus("Claimed");
            foodItemDAO.updateFoodItem(foodItem);
            
            // Optionally, update the inventory count here
            
            return true; // Successfully claimed
        } else {
            return false; // Item not available for claiming
        }
    }

    // Method to update the inventory after a food item is claimed
    // This could either decrement the count or remove the item from the list
    public void updateInventory(int foodItemId) {
        // This method might remove the item or decrement its quantity
        // Assuming the FoodItem model has a quantity field
        FoodItem foodItem = foodItemDAO.getFoodItemById(foodItemId);
        if (foodItem != null) {
            int newQuantity = foodItem.getQuantity() - 1; // Assuming each claim decrements quantity by 1
            if (newQuantity <= 0) {
                // If no more items left, might choose to delete or mark as fully claimed
                foodItemDAO.deleteFoodItem(foodItemId); // Or mark as "Fully Claimed"
            } else {
                foodItem.setQuantity(newQuantity);
                foodItemDAO.updateFoodItem(foodItem);
            }
        }
    }
}
