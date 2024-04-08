package com.fwrp.service;

import com.fwrp.dao.AppDataSource;
import com.fwrp.dao.SubscriptionDAO;
import com.fwrp.model.Subscription;

//import javax.sql.DataSource;

public class SubscriptionService {
    private SubscriptionDAO subscriptionDAO;

    public SubscriptionService() {
    	AppDataSource dataSource = AppDataSource.getInstance();
        this.subscriptionDAO = new SubscriptionDAO(dataSource);
    }

    public void subscribeToItem(int userId, int foodItemId, String notificationMethod,String location, String communicationMethod, String foodPreferences) {
        Subscription subscription = new Subscription();
        
        subscription.setUserId(userId);
        subscription.setFoodItemId(foodItemId); 
        subscription.setLocation(location);
        subscription.setCommunicationMethod(communicationMethod); // this field exists in the Subscription model
        subscription.setPreference(foodPreferences); 
        
        // Set any other necessary fields for Subscription
        subscriptionDAO.addSubscription(subscription);
   
    }
    
    // ... additional subscription-related methods
}
