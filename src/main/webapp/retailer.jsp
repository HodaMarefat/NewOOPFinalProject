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
         <h2>Inventory Actions</h2>
        <!-- Link to add a new food item -->
        <a href="retail_addFoodItem">Add New Food Item</a><br/>
        <!-- Link to update a food item (Assuming there's a form/page for this) -->
        <a href="retail_updateFoodItem">Update Food Item</a><br/>
        <!-- Link to list surplus items (Assuming there's a form/page for this) -->
        <a href="listSurplusItemForm">List Surplus Item</a><br/>
        <!-- Link to mark an item for donation (Assuming there's a form/page for this) -->
        <a href="markForDonationForm">Mark Item for Donation</a><br/>
        <!-- Link to mark an item for sale (Assuming there's a form/page for this) -->
        <a href="markForSaleForm">Mark Item for Discount Sale</a>
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
