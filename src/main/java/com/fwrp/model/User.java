package com.fwrp.model;


public class User {
    private int userId;
    private String userName;
    private String email;
    private String password;
    private String userType; //  "Retailer", "Consumer", "CharitableOrganization"
	private String favoriteIngredient;
  
	
	public User(String userName, String email, String password, String userType, String favoriteIngredient) {
	    this.userName = userName;
	    this.email = email;
	    this.password = password;
	    this.userType = userType;
	    this.favoriteIngredient = favoriteIngredient;
	    // UserID is not set here, will be set after insertion into the database
	}

    // Default constructor
    public User() {
    }

    // Parameterized constructor for all fields
    public User(int userId, String userName, String email, String password, String userType, String favoriteIngredient) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.favoriteIngredient = favoriteIngredient;
    }

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFavoriteIngredient() {
    	return favoriteIngredient;
    }

	public void setFavoriteIngredient(String favoriteIngredient) {
		this.favoriteIngredient = favoriteIngredient;
		
	}
}
