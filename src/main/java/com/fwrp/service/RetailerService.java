package com.fwrp.service;

import com.fwrp.dao.FoodItemDAO;
import com.fwrp.model.FoodItem;

import java.util.List;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RetailerService {
    private FoodItemDAO foodItemDAO;

    public RetailerService() {
        this.foodItemDAO = new FoodItemDAO(); // Ideally, use dependency injection here
    }

    // Add a new food item to the inventory
    public void addFoodItem(FoodItem foodItem) {
        foodItemDAO.addFoodItem(foodItem);
    }

    // Update a food item in the inventory
    public void updateFoodItem(FoodItem foodItem) {
        foodItemDAO.updateFoodItem(foodItem);
    }

    // Delete a food item from the inventory
    public void deleteFoodItem(int foodItemId) {
        foodItemDAO.deleteFoodItem(foodItemId);
    }

    // List all food items of the retailer
    public List<FoodItem> getAllFoodItems(int retailerId) {
        List<FoodItem> allItems = foodItemDAO.getAllFoodItems();
        // Filter items by retailerId if needed, assuming FoodItem has a retailerId field
        return allItems.stream().filter(item -> item.getRetailerId() == retailerId)
                       .collect(Collectors.toList());
    }

    // Identify and list all surplus food items
    public List<FoodItem> identifySurplusFoodItems(int retailerId) {
        List<FoodItem> allItems = getAllFoodItems(retailerId);
        LocalDate now = LocalDate.now();
        LocalDate oneWeekFromNow = now.plus(1, ChronoUnit.WEEKS);

        return allItems.stream()
                       .filter(item -> item.getExpirationDate().isAfter(now) && item.getExpirationDate().isBefore(oneWeekFromNow))
                       .collect(Collectors.toList());
    }


    // List a surplus food item for sale or donation
    public void listSurplusItem(FoodItem foodItem, boolean forSale) {
        // Mark the item as surplus and set its sale status and discount rate
        foodItem.setStatus(forSale ? "For Sale" : "For Donation");
         // final price is determined in the transaction class
        updateFoodItem(foodItem);
    }

    // Mark a food item for donation
    public void markItemForDonation(int foodItemId) {
        FoodItem foodItem = foodItemDAO.getFoodItemById(foodItemId);
        if (foodItem != null) {
            foodItem.setStatus("For Donation");
            foodItem.setPrice(0.0); //  setting the price to 0 indicates donation
            updateFoodItem(foodItem);
        }
    }

    // Mark a food item for sale at a discounted price
    public void markItemForDiscountSale(int foodItemId, double discountRate) {
        FoodItem foodItem = foodItemDAO.getFoodItemById(foodItemId);
        if (foodItem != null) {
            foodItem.setStatus("For Sale");
            double originalPrice = foodItem.getPrice(); // Assuming FoodItem has a getPrice() method
            double discountedPrice = originalPrice * (1 - discountRate);
            foodItem.setPrice(discountedPrice); // Apply the discount to the price
            updateFoodItem(foodItem);
        }
    }

}
