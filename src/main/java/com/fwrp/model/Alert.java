package com.fwrp.model;

import java.util.Date;

public class Alert {
    private int alertId;
    private int userId;
    private int foodItemId;
    private Date alertDate;
    private AlertType alertType;
    private Status status;
    private String message;

    // Enum for AlertType
    public enum AlertType {
        EMAIL, PHONE
    }

    // Enum for Status
    public enum Status {
        SENT, NOT_SENT
    }

    // Constructor
    public Alert(int alertId, int userId, int foodItemId, Date alertDate, AlertType alertType, Status status, String message) {
        this.alertId = alertId;
        this.userId = userId;
        this.foodItemId = foodItemId;
        this.alertDate = alertDate;
        this.alertType = alertType;
        this.status = status;
        this.message = message;
    }

    // Getters and Setters
    public int getAlertId() {
        return alertId;
    }

    public void setAlertId(int alertId) {
        this.alertId = alertId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(int foodItemId) {
        this.foodItemId = foodItemId;
    }

    public Date getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Date alertDate) {
        this.alertDate = alertDate;
    }

    public AlertType getAlertType() {
        return alertType;
    }

    public void setAlertType(AlertType alertType) {
        this.alertType = alertType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
