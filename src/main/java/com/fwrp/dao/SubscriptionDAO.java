package com.fwrp.dao;

import com.fwrp.model.Subscription;
import com.fwrp.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SubscriptionDAO {
    private AppDataSource appDataSource;

    public SubscriptionDAO(AppDataSource appDataSource) {
        this.appDataSource = appDataSource;
    }

    public List<Subscription> getAllSubscriptions() {
        List<Subscription> subscriptions = new ArrayList<>();
        String sql = "SELECT s.*, u.* FROM Subscriptions s INNER JOIN Users u ON s.user_id = u.id";
        try (Connection conn = appDataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Subscription subscription = new Subscription();
                subscription.setSubscriptionId(rs.getInt("s.id"));
                
                User user = new User();
                user.setUserId(rs.getInt("u.id"));
                user.setUserName(rs.getString("userName"));  // User table has these fields
                user.setEmail(rs.getString("u.email"));
                // Populate other User fields as needed
                subscription.setUserId(user.getUserId()); 
                
                subscription.setLocation(rs.getString("s.location"));
                subscription.setPreference(rs.getString("s.preference"));
                subscription.setCommunicationMethod(rs.getString("s.communicationMethod")); // Adjust column name as needed
                subscriptions.add(subscription);
            }
        } catch (SQLException e) {
            // Consider logging this exception
            e.printStackTrace();
        }
        return subscriptions;
    }

    public void addSubscription(Subscription subscription) {
        String sql = "INSERT INTO Subscriptions (user_id, location, preference, communicationMethod) VALUES (?, ?, ?, ?)";
        try (Connection conn = appDataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, subscription.getUserId());
            pstmt.setString(2, subscription.getLocation());
            pstmt.setString(3, subscription.getPreference());
            pstmt.setString(4, subscription.getCommunicationMethod()); // Ensure this matches your schema
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Consider logging this exception
            e.printStackTrace();
        }
    }

    public void updateSubscription(Subscription subscription) {
        String sql = "UPDATE Subscriptions SET location=?, preference=?, communicationMethod=? WHERE id=?";
        try (Connection conn = appDataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, subscription.getLocation());
            pstmt.setString(2, subscription.getPreference());
            pstmt.setString(3, subscription.getCommunicationMethod()); // Ensure this matches your schema
            pstmt.setInt(4, subscription.getSubscriptionId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Consider logging this exception
            e.printStackTrace();
        }
    }

    public void deleteSubscription(int subscriptionId) {
        String sql = "DELETE FROM Subscriptions WHERE id=?";
        try (Connection conn = appDataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, subscriptionId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Consider logging this exception
            e.printStackTrace();
        }
    }
}
