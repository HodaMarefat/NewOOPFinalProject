package com.fwrp.dao;

import com.fwrp.model.Transaction;
import com.fwrp.model.User;
import com.fwrp.model.FoodItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    
    private AppDataSource dataSource;

    public TransactionDAO() {
        // Get the singleton DataSource instance
        this.dataSource = AppDataSource.getInstance();
    }

    // Method to get all Transactions from the database
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM Transactions";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(rs.getInt("id"));
                
                // Assuming a User object needs to be constructed for each transaction
                User buyer = new User(); // Needs to be implemented to match your User class
                buyer.setUserId(rs.getInt("UserID")); //  the actual column name
                transaction.setBuyer(buyer);
                
                // Similarly for FoodItem
                FoodItem foodItem = new FoodItem(); // Needs to be implemented to match your FoodItem class
                foodItem.setFoodItemId(rs.getInt("FoodItemID")); //  actual column name
                transaction.setFoodItem(foodItem);

                transaction.setQuantity(rs.getInt("Quantity"));
                transaction.setDiscountRate(rs.getDouble("DiscountRate"));
                // method to calculate the total price based on the discount
                //calculateTotalPrice(double itemPrice, int quantity, double discountRate)
                double totalPrice = transaction.calculateTotalPrice(
                	    transaction.getFoodItem().getPrice(),
                	    transaction.getQuantity(),
                	    transaction.getDiscountRate()
                	);
                
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper error handling
        }
        return transactions;
    }

    // Method to add a Transaction to the database
    public void addTransaction(Transaction transaction) {
        String sql = "INSERT INTO Transactions (FoodItemID,  UserID, Quantity, DiscountRate) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, transaction.getBuyer().getUserId());
            pstmt.setInt(2, transaction.getFoodItem().getFoodItemId());
            pstmt.setInt(3, transaction.getQuantity());
            pstmt.setDouble(4, transaction.getDiscountRate());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper error handling
        }
    }

 // Method to update a Transaction in the database
    public void updateTransaction(Transaction transaction) {
        String sql = "UPDATE Transactions SET FoodItemID=?, UserID=?,  Quantity=?, DiscountRate=? WHERE id=?";
        
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, transaction.getBuyer().getUserId());
            pstmt.setInt(2, transaction.getFoodItem().getFoodItemId());
            pstmt.setInt(3, transaction.getQuantity());
            pstmt.setDouble(4, transaction.getDiscountRate());
            pstmt.setInt(5, transaction.getTransactionId());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper error handling
        }
    }

    // Method to delete a Transaction from the database
    public void deleteTransaction(int id) {
        String sql = "DELETE FROM Transactions WHERE id=?";
        
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper error handling
        }
    }
}
