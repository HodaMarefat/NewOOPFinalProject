package com.fwrp.model;

public class Subscription {
	private int subscriptionId;
    private int foodId;
    private int userId;
    private String location;
    private String preference;
	private String communicationMethod;

 // Constructor
    public Subscription() {
    }

    // Getters and setters
    public int getfoodId() {
        return foodId;
    }

    public void setFoodItemId(int foodId) {
        this.foodId = foodId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
    
    public String getCommunicationMethod() {
        return communicationMethod;
    }
    public void setCommunicationMethod(String communicationMethod) {
        this.communicationMethod= communicationMethod;
    }
    
    public int getSubscriptionId() {
        return subscriptionId;
    }
    
    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

	
}
