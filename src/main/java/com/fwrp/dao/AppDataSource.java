package com.fwrp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppDataSource {
    
    // Database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/javafinalproject";
    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "Zelat1&Mys";
    
    // Instance of DataSource
    private static AppDataSource instance = null;
    
    // Private constructor to prevent instantiation
    private AppDataSource() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    // Method to get instance of DataSource
    public static AppDataSource getInstance() {
        if (instance == null) {
            // Thread-safe instantiation of the singleton instance
            synchronized (AppDataSource.class) {
                if (instance == null) {
                    instance = new AppDataSource();
                }
            }
        }
        return instance;
    }
    
    // Method to get a database connection
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
