package com.fwrp.model;

public class Transaction {
    private int transactionId;
    private FoodItem foodItem;
    private User buyer; //  User class has a userType to distinguish consumers
    private int quantity;
    private double discountRate; // Represented as a percentage (e.g., 10 for 10%)
    private double totalPrice; // Calculated as (item price - discount) * quantity
    
    
    // Default constructor
    public Transaction() {
    }

    // Parameterized constructor
    public Transaction(int transactionId, User buyer, FoodItem foodItem, int quantity, double discountRate) {
        this.transactionId = transactionId;
        this.foodItem = foodItem;
        this.buyer = buyer;
        this.quantity = quantity;
        this.discountRate = discountRate;
        this.totalPrice = calculateTotalPrice(foodItem.getPrice(), quantity, discountRate);
    }

    // Method to calculate total price
    public double calculateTotalPrice(double itemPrice, int quantity, double discountRate) {
        double discountAmount = itemPrice * (discountRate / 100);
        return (itemPrice - discountAmount) * quantity;
    }

    // Getters
    public int getTransactionId() {
        return transactionId;
    }

    public User getBuyer() {
        return buyer;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // Setters
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
        // Recalculate total price whenever the discount rate changes
        this.totalPrice = calculateTotalPrice(this.foodItem.getPrice(), this.quantity, this.discountRate);
    }

    //  totalPrice wouldn't have a setter as it's derived from other fields
}
