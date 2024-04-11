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
        <h1>List Surplus Items</h1>
    </header>
    
    <div class="container">
        <!-- Dynamically generate items here -->
        <c:forEach items="${surplusItems}" var="item">
            <div class="item" data-status="${item.status}">
            <h3>Item Name: ${item.foodName}</h3>
            <p>Description: ${item.description}</p>
            <p>Quantity: ${item.quantity}</p>
            <p>Status: ${item.status}</p>
            <p>Price: $${item.price}</p>
            <p>Category: ${item.category}</p>
            <p>Expiration Date: ${item.expirationDate}</p>
        </div>
        </c:forEach>
    </div>
    
    <footer>
        <p>© 2024 Retailer Dashboard</p>
    </footer>
</body>
</html>
