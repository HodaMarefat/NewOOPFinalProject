package com.fwrp.model;

public class Recipe {
    private int recipeId;
    private String recipeName;
    private String description;
    private String ingredients; // Comma-separated ingredients
    private String preparationMethod;
    private String dietaryRestrictions; // Comma-separated dietary restrictions
    private double rating; // Average rating from users

    // Default constructor
    public Recipe() {
    }

    // Constructor with all fields
    public Recipe(int recipeId, String recipeName, String description, String ingredients,
                  String preparationMethod, String dietaryRestrictions, double rating) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.description = description;
        this.ingredients = ingredients;
        this.preparationMethod = preparationMethod;
        this.dietaryRestrictions = dietaryRestrictions;
        this.rating = rating;
    }

    // Getters
    public int getrecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getPreparationMethod() {
        return preparationMethod;
    }

    public String getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public double getRating() {
        return rating;
    }

    // Setters
    public void setrecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setPreparationMethod(String preparationMethod) {
        this.preparationMethod = preparationMethod;
    }

    public void setDietaryRestrictions(String dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
