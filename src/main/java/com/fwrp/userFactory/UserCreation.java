package com.fwrp.userFactory;
import com.fwrp.model.User;


public class UserCreation {
    public static void main(String[] args) {
        // Create and set properties for a Retailer user
        User retailer = UserFactory.createUser("Retailer");
        retailer.setUserName("RetailerName");
        retailer.setEmail("retailer@example.com");
        retailer.setPassword("retailer123");
        retailer.setFavoriteIngredient("Tomatoes");

        // Create and set properties for a Consumer user
        User consumer = UserFactory.createUser("Consumer");
        consumer.setUserName("ConsumerName");
        consumer.setEmail("consumer@example.com");
        consumer.setPassword("consumer123");
        consumer.setFavoriteIngredient("Apples");

        // Create and set properties for a Charitable Organization user
        User charitableOrganization = UserFactory.createUser("CharitableOrganization");
        charitableOrganization.setUserName("CharityOrgName");
        charitableOrganization.setEmail("charity@example.com");
        charitableOrganization.setPassword("charity123");
        charitableOrganization.setFavoriteIngredient("Carrots");

        // Use the user objects as needed
        // For demonstration, just printing the user type and email
        System.out.println("Created Retailer: " + retailer.getEmail());
        System.out.println("Created Consumer: " + consumer.getEmail());
        System.out.println("Created Charitable Organization: " + charitableOrganization.getEmail());
    }
}
