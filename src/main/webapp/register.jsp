<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Page</title>
    <!-- Include any necessary CSS or JS files -->
</head>
<body>
    <h2>Registration</h2>
    <form method="post" action="register">
        <input type="hidden" name="action" value="register">
        
        <!-- UserName Field -->
        <label for="registerUsername">Username:</label><br>
        <input type="text" id="registerUsername" name="userName" required><br>
        
        <!-- Email Field -->
        <label for="registerEmail">Email:</label><br>
        <input type="email" id="registerEmail" name="email" required><br>
        
        <!-- Password Field -->
        <label for="registerPassword">Password:</label><br>
        <input type="password" id="registerPassword" name="password" required><br>
        
        <!-- UserType Selection -->
        <label for="userType">User Type:</label><br>
        <select name="userType" id="userType" required>
            <option value="Consumer">Consumer</option>
            <option value="CharitableOrganization">Charitable Organization</option>
            <option value="Retailer">Retailer</option>
        </select><br><br>
        
        <!-- FavoriteIngredient (Optional) -->
        <label for="favoriteIngredient">Favorite Ingredient (Optional):</label><br>
        <input type="text" id="favoriteIngredient" name="favoriteIngredient"><br><br>
        
        <input type="submit" value="Register">
    </form>
</body>
</html>
