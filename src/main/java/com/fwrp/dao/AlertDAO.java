package com.fwrp.dao;

import com.fwrp.model.Alert;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlertDAO {
    
    public boolean insertAlert(Alert alert) {
        String sql = "INSERT INTO Alerts (UserID, FoodItemID, AlertDate, AlertType, Status, Message) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = AppDataSource.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, alert.getUserId());
            statement.setInt(2, alert.getFoodItemId());
            statement.setTimestamp(3, new Timestamp(alert.getAlertDate().getTime()));
            statement.setString(4, alert.getAlertType().toString());
            statement.setString(5, alert.getStatus().toString());
            statement.setString(6, alert.getMessage());
            
            boolean rowInserted = statement.executeUpdate() > 0;
            return rowInserted;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Alert> listAllAlerts() {
        List<Alert> listAlert = new ArrayList<>();
        String sql = "SELECT * FROM Alerts";
        
        try (Connection connection = AppDataSource.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            
            while (resultSet.next()) {
                int id = resultSet.getInt("AlertID");
                int userId = resultSet.getInt("UserID");
                int foodItemId = resultSet.getInt("FoodItemID");
                Timestamp alertDate = resultSet.getTimestamp("AlertDate");
                Alert.AlertType alertType = Alert.AlertType.valueOf(resultSet.getString("AlertType"));
                Alert.Status status = Alert.Status.valueOf(resultSet.getString("Status"));
                String message = resultSet.getString("Message");
                
                Alert alert = new Alert(id, userId, foodItemId, new Date(alertDate.getTime()), alertType, status, message);
                listAlert.add(alert);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listAlert;
    }
}
