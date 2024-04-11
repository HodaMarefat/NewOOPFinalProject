<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Surplus Food Listings</title>
    <style>
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }
        .item {
            border: 1px solid #ddd;
            margin: 10px;
            padding: 10px;
            border-radius: 5px;
            width: 30%;
        }
        .item h3 {
            color: #4CAF50;
        }
    </style>
</head>
<body>
    <header>
        <h1> Foods Listing</h1>
    </header>

    <div class="container">
        <!-- Dynamically generate items here -->
        <c:forEach items="${foodItems}" var="item">
            <div class="item" data-status="${item.status}">
            <h3>Item Name: ${item.foodName}</h3>
            <p>Description: ${item.description}</p>
            <p>Quantity: ${item.quantity}</p>
            <p>Status: ${item.status}</p>
            <p>Price: $${item.price}</p>
            <p>Category: ${item.category}</p>
        </div>
        </c:forEach>
    </div>

    <footer>
        <p>Food Waste Reduction Platform © 2024</p>
    </footer>
</body>
</html>
