package com.fwrp.dao;

import com.fwrp.model.FoodItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FoodItemDAO {
	 // Instance of DataSource
    private AppDataSource dataSource;
 
    public FoodItemDAO() {
    	// Retrieve the singleton instance of DataSource
        this.dataSource = AppDataSource.getInstance();
    }

    // Method to get all FoodItems from the database
    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> foodItems = new ArrayList<>();
        String sql = "SELECT * FROM javafinalproject.FoodItems"; //  a table named FoodItems

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                FoodItem item = new FoodItem();
                item.setFoodItemId(rs.getInt("foodItemID"));
                item.setFoodName(rs.getString("foodName"));
                item.setDescription(rs.getString("description"));
                item.setQuantity(rs.getInt("quantity"));
                item.setStatus(rs.getString("status")); // For sale or donation
                item.setPrice(rs.getDouble("price")); // 
                item.setCategory(rs.getString("category")); // a category column
                foodItems.add(item);
            }
        } catch (SQLException e) {
            // Handle exceptions (print stack trace is for debugging, should be logged in production)
            e.printStackTrace();
        }
        return foodItems;
    }

    // Method to add a FoodItem to the database
    public void addFoodItem(FoodItem item) {
        String sql = "INSERT INTO javafinalproject.foodItems (foodName, description, quantity, status, price, category, retailerId, ExpirationDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, item.getFoodName());
            pstmt.setString(2, item.getDescription());
            pstmt.setInt(3, item.getQuantity());
            pstmt.setString(4, item.getStatus());
            pstmt.setDouble(5, item.getPrice());
            pstmt.setString(6, item.getCategory());
            pstmt.setInt(7, item.getRetailerId());
            pstmt.setDate(8, java.sql.Date.valueOf(item.getExpirationDate()));
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
    
    public void updateFoodItem(FoodItem item) {
        String sql = "UPDATE javafinalproject.FoodItems SET foodName=?, description=?, quantity=?, status=?, price=?, category=? WHERE foodItemId=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, item.getFoodName());
            pstmt.setString(2, item.getDescription());
            pstmt.setInt(3, item.getQuantity());
            pstmt.setString(4, item.getStatus());
            pstmt.setDouble(5, item.getPrice());
            pstmt.setString(6, item.getCategory());
            pstmt.setInt(7, item.getFoodItemId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper error handling
        }
    }

    public void deleteFoodItem(int id) {
        String sql = "DELETE FROM javafinalproject.FoodItems WHERE foodItemID=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper error handling
        }
    }
    
    public FoodItem getFoodItemById(int foodItemId) {
        FoodItem foodItem = null;
        String sql = "SELECT * FROM javafinalproject.FoodItems WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, foodItemId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                foodItem = new FoodItem();
                foodItem.setFoodItemId(rs.getInt("id"));
                foodItem.setFoodName(rs.getString("foodName"));
                foodItem.setDescription(rs.getString("description"));
                foodItem.setQuantity(rs.getInt("quantity"));
                foodItem.setStatus(rs.getString("status"));
                foodItem.setPrice(rs.getDouble("price"));
                foodItem.setCategory(rs.getString("category"));
                
                // Assuming the expiration date is stored as a date in the database
                LocalDate expirationDate = rs.getDate("expirationDate").toLocalDate();
                foodItem.setExpirationDate(expirationDate);
                
                // Assuming FoodItem class has setExpirationDate() method accepting LocalDate
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Proper error handling should replace this
        }
        
        return foodItem;
    }
    
    public FoodItem getFoodItemByName(String name) {
        FoodItem foodItem = null;
        String sql = "SELECT * FROM javafinalproject.FoodItems WHERE  foodName = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
        	pstmt.setString(1, name);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int foodItemId = rs.getInt("FoodItemID");
                    String foodName = rs.getString("foodName");
                    String description = rs.getString("Description");
                    int quantity = rs.getInt("Quantity");
                    String status = rs.getString("Status");
                    double price = rs.getDouble("Price");
                    String category = rs.getString("Category");
                    int retailerId = rs.getInt("RetailerID");
                    LocalDate expirationDate = rs.getDate("ExpirationDate").toLocalDate();

                    foodItem = new FoodItem();  // Assuming an appropriate constructor or use setters
                    foodItem.setFoodItemId(foodItemId);
                    foodItem.setFoodName(foodName);
                    foodItem.setDescription(description);
                    foodItem.setQuantity(quantity);
                    foodItem.setStatus(status);
                    foodItem.setPrice(price);
                    foodItem.setCategory(category);
                    foodItem.setRetailerId(retailerId);
                    foodItem.setExpirationDate(expirationDate);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Proper error handling should replace this
        }
        
        return foodItem;
    }
}
