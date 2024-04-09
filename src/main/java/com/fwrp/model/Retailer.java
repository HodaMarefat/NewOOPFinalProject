package com.fwrp.model;

public class Retailer extends User {
    // Retailer-specific attributes
    private String storeName;
    private String location;
    
    // Default constructor
    public Retailer() {
        super(); // Call to the superclass (User) default constructor
    }
    
    // parametrized constructor
    public Retailer(String userName, String email, String password, String userType, String favoriteIngredient, String storeName, String location) {
        super(userName, email, password, userType, favoriteIngredient);
        this.storeName = storeName;
        this.location = location;
    }

     // Getters and Setters
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
