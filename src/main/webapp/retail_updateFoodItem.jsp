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
    
    <!-- Assuming you have a FoodItem object available as 'foodItem' with its properties -->
    <form action="retail_updateFoodItem" method="post">
        <!-- Hidden input for Food Item ID if needed -->
        <input type="hidden" id="itemId" name="itemId" value="${foodItem.itemId}"> 

        <div>
            <label for="name">Food Name:</label>
            <input type="text" id="name" name="name" value="${foodItem.name}" required>
        </div>
        
        <div>
            <label for="description">Description:</label>
            <textarea id="description" name="description" >${foodItem.description}</textarea>
        </div>
        
        <div>
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" value="${foodItem.quantity}" min="1" >
        </div>
        
        <div>
            <label for="price">Price:</label>
            <input type="text" id="price" name="price" value="${foodItem.price}" >
        </div>
        
        <div>
            <label for="expirationDate">Expiration Date:</label>
            <!-- Format the date value as 'YYYY-MM-DD' to properly fill the input type="date" -->
            <input type="date" id="expirationDate" name="expirationDate" >
        </div>
        
        <button type="submit">Update Food Item</button>
    </form>
    
    <footer>
        <p>© 2024 Retailer Dashboard</p>
    </footer>
</body>
</html>
