/* 
 * This UserService class handles user management tasks like registration and login, 
 * including email format validation, using a UserDAO for database operations.
 */
package com.fwrp.service;

import com.fwrp.dao.UserDAO;
import com.fwrp.model.User;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    // Method to handle user registration
    public void registerUser(String name, String email, String password, String userType) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        
        User user = new User();
        user.setUserName(name);
        user.setEmail(email);
        user.setPassword(password); // Directly storing the password without hashing
        user.setUserType(userType);
        
        userDAO.addUser(user);
    }

    // Simplified version without password hashing
    public boolean registerUser(User user) {
        if (user.getUserName() == null || user.getEmail() == null || user.getPassword() == null) {
            return false; // Basic validation failed
        }

        try {
            userDAO.addUser(user); // Directly add the user without modifying the password
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to handle user login
    public Optional<User> loginUser(String email, String password) {
        Optional<User> user = userDAO.findUserByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) { // Directly compare the plain text password
            return user;
        }
        return Optional.empty();
    }
    
    // Additional methods such as updateUser, deleteUser, etc.

    // Helper method to validate email
    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
