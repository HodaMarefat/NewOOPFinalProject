package com.fwrp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/javafinalproject";
        String username = "root";
        String password = "Zelat1&Mys";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to the database.");

            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM foodItems";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                //  a column named 'foodName' in table
                String name = resultSet.getString("foodName");
                System.out.println("Fetched name: " + name);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
