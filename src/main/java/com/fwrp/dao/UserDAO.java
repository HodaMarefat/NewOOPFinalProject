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
                user.setUserId(rs.getInt("id"));
                user.setUserName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                // Set other properties of User here
                
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper error handling
        }
        return users;
    }

    // Method to add a User to the database
    public void addUser(User user) {
        String sql = "INSERT INTO Users (name, email) VALUES (?, ?)";
        
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getEmail());
            // Set other properties of User here
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper error handling
        }
    }

    // Method to update a User in the database
    public void updateUser(User user) {
        String sql = "UPDATE Users SET name=?, email=? WHERE id=?";
        
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getEmail());
            // Set other properties of User here
            pstmt.setInt(3, user.getUserId());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper error handling
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
        String sql = "SELECT * FROM Users WHERE email = ?";
        User user = null;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    // Populate user object
                    user.setUserId(rs.getInt("id"));
                    user.setUserName(rs.getString("name"));
                    user.setEmail(email);
                    user.setPassword(rs.getString("password")); // Assuming password is stored hashed
                    user.setUserType(rs.getString("user_type"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Replace with proper error handling
        }
        
        return Optional.ofNullable(user);
    }
}
