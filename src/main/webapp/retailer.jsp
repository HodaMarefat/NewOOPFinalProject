<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Retailer Dashboard</title>
    
</head>
<body>
    <header>
        <h1>Retailer Dashboard</h1>
        <nav>
            <a href="index.jsp">Home</a> |
            <a href="about-contact.jsp">About/Contact</a> |
            <a href="foodItem">Surplus Foods</a> |
            <a href="subscribe-alerts.jsp">Subscribe</a>
        </nav>
    </header>
    
    <section>
        <h2>Inventory Management</h2>
        <a href="addFoodItemForm.jsp">Add New Food Item</a> <!-- Link to a form for adding new food items -->
        <!-- Inventory list could go here, with options to update or delete each item -->
    </section>
    
    <section>
        <h2>Surplus Food Items</h2>
        <!-- Form for identifying and listing surplus items -->
        <form action="identifySurplusItems" method="get">
            <input type="hidden" name="retailerId" value="${user.userId}"> <!-- Assuming userId is stored in the session -->
            <button type="submit">Identify Surplus Items</button>
        </form>
        
        <!-- Optionally, list identified surplus items here with options to mark them for sale or donation -->
    </section>
    
    <footer>
        <p>Retailer Dashboard © 2024</p>
    </footer>
</body>
</html>
