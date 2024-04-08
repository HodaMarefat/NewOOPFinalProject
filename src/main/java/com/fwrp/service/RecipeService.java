package com.fwrp.service;

import com.fwrp.dao.RecipeDAO;
import com.fwrp.model.Recipe;
import com.fwrp.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeService {
    private RecipeDAO recipeDAO;

    public RecipeService() {
        this.recipeDAO = new RecipeDAO(); // Ideally, use dependency injection
    }

    /**
     * Suggests recipes based on user preferences and available surplus food items.
     * 
     * @param user The user for whom recipes are being suggested.
     * @return A list of Recipe objects that match the user's preferences and allergies.
     */
    public List<Recipe> suggestRecipes(User user) {
        List<Recipe> allRecipes = recipeDAO.getAllRecipes();
        
        // For simplicity, let's assume the user has a single favorite ingredient or preference.
        // And we'll ignore allergies in this simplified example.
        String favoriteIngredient = user.getFavoriteIngredient(); // User model needs a method to get this.

        // Filter recipes that include the user's favorite ingredient.
        List<Recipe> suggestedRecipes = allRecipes.stream()
                .filter(recipe -> recipe.getIngredients().contains(favoriteIngredient))
                .collect(Collectors.toList());

        return suggestedRecipes;
    }

    // Additional methods as needed for recipe management
}
