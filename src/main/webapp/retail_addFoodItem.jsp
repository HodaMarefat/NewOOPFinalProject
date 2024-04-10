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
        <h1>Add a New Food Item</h1>
    </header>
    
    <form action="retail_addFoodItem" method="post">
        <div>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        
        <div>
            <label for="description">Description:</label>
            <textarea id="description" name="description" required></textarea>
        </div>
        
        <div>
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" min="1" required>
        </div>
        
        <div>
            <label for="price">Price:</label>
            <input type="text" id="price" name="price" required>
        </div>
        
        <div>
            <label for="expirationDate">Expiration Date:</label>
            <input type="date" id="expirationDate" name="expirationDate" required>
        </div>
        
        <button type="submit">Add Food Item</button>
    </form>
    
    <footer>
        <p>© 2024 Retailer Dashboard</p>
    </footer>
</body>
</html>
