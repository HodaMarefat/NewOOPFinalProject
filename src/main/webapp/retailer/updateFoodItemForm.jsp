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
        <h1>Update Food Item</h1>
    </header>
    
    <form action="updateFoodItem" method="POST">
        <!-- Hidden field for food item ID (assuming it's known and set in the request) -->
        <input type="hidden" id="foodItemId" name="foodItemId" value="${foodItem.id}">
        
        <div>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${foodItem.name}" required>
        </div>
        
        <div>
            <label for="description">Description:</label>
            <textarea id="description" name="description" required>${foodItem.description}</textarea>
        </div>
        
        <div>
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" min="1" value="${foodItem.quantity}" required>
        </div>
        
        <div>
            <label for="price">Price:</label>
            <input type="text" id="price" name="price" value="${foodItem.price}" required>
        </div>
        
        <div>
            <label for="expirationDate">Expiration Date:</label>
            <input type="date" id="expirationDate" name="expirationDate" value="${foodItem.expirationDate}" required>
        </div>
        
        <button type="submit">Update Food Item</button>
    </form>
    
    <footer>
        <p>© 2024 Retailer Dashboard</p>
    </footer>
</body>
</html>