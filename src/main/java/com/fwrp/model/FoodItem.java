package com.fwrp.model;

import java.time.LocalDate;

public class FoodItem {
    private int foodItemId;
    private String foodName;
    private String description;
    private int quantity;
    private String status; // For Sale or For Donation
    private double price; //  price field
    private String category; //  category or type
    private int retailerId;
    private LocalDate  expirationDate;
    
    // Updated constructor with price and category
    public FoodItem(int foodItemId, String foodName, String description, int quantity, String status, double price, 
    		String category, int retailerId, LocalDate  expirationDate) {
    	
        this.foodItemId = foodItemId;
        this.foodName = foodName;
        this.description = description;
        this.quantity = quantity;
        this.status = status;
        this.price = price;
        this.category = category;
        this.retailerId = retailerId;
        this.expirationDate = expirationDate;
    }

    // Default constructor
    public FoodItem() {
    }

    // Getters
    public int getFoodItemId() {
        return foodItemId;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
    
	public int getRetailerId() {
		return retailerId;
	}
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}

    // Setters
    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    public void setExpirationDate(LocalDate  expirationDate) {
        this.expirationDate = expirationDate;
    }
}
