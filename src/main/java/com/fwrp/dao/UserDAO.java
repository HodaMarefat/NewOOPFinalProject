package com.fwrp.dao;

import com.fwrp.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO {
    
    private AppDataSource dataSource;

    public UserDAO() {
        this.dataSource = AppDataSource.getInstance();
    }

    // Method to get all Users from the database
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("UserID")); // Adjusted to match column name
                user.setUserName(rs.getString("UserName")); // Adjusted to match column name
                user.setEmail(rs.getString("Email")); // Correct as is
                user.setPassword(rs.getString("Password")); // Added to match schema
                user.setUserType(rs.getString("UserType")); // Added to match schema
                user.setFavoriteIngredient(rs.getString("FavoriteIngredient")); // Added to match schema
                
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper error handling
        }
        return users;
    }

    // Method to add a User to the database
    public void addUser(User user) {
    	 // SQL query includes Password, UserType, and FavoriteIngredient
        String sql = "INSERT INTO Users (UserName, Email, Password, UserType, FavoriteIngredient) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword()); // getPassword() method exists
            pstmt.setString(4, user.getUserType()); // getUserType() method returns a String
            pstmt.setString(5, user.getFavoriteIngredient()); // getFavoriteIngredient() method exists
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // proper error handling
        }
    }

    // Method to update a User in the database
    public void updateUser(User user) {
        // Updated SQL statement to match column names and include all updatable fields
        String sql = "UPDATE Users SET UserName=?, Email=?, Password=?, UserType=?, FavoriteIngredient=? WHERE UserID=?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set parameters based on the user object
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword()); // might want to update the password
            pstmt.setString(4, user.getUserType()); // UserType must match one of the ENUM values
            pstmt.setString(5, user.getFavoriteIngredient()); // Can be null
            pstmt.setInt(6, user.getUserId()); // WHERE clause to identify the user to update

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Proper error handling should be implemented
        }
    }

    // Method to delete a User from the database
    public void deleteUser(int id) {
        String sql = "DELETE FROM Users WHERE id=?";
        
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper error handling
        }
    }
    
 // Method to find a User by email
    public Optional<User> findUserByEmail(String email) {
        String sql = "SELECT * FROM Users WHERE Email = ?";
        User user = null;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    // Populate user object according to the SQL schema provided
                    user.setUserId(rs.getInt("UserID"));
                    user.setUserName(rs.getString("UserName"));
                    user.setEmail(email); 
                    user.setPassword(rs.getString("Password"));
                    user.setUserType(rs.getString("UserType"));
                    user.setFavoriteIngredient(rs.getString("FavoriteIngredient"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Proper error handling should be implemented
        }
        
        return Optional.ofNullable(user);
    }

}
