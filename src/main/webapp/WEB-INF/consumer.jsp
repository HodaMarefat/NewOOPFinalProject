<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consumer Dashboard</title>
    
</head>
<body>
    <header>
        <h1>Consumer Dashboard</h1>
        <nav>
            <a href="index.jsp">Home</a> |
            <a href="about-contact.jsp">About/Contact</a> |
            <a href="foodItem">Surplus Foods</a> |
            <a href="subscribe-alerts.jsp">Subscribe</a>
        </nav>
    </header>
    
    <section>
        <h2>Available Surplus Foods</h2>
        <p>Discover and purchase surplus food items at a discount.</p>
        <!-- Food items listing. Assuming each item has a unique ID, name, discount rate, and a purchase link -->
        <c:forEach var="foodItem" items="${foodItems}">
            <div>
                <p>${foodItem.name} - <strong>${foodItem.discountRate}% Off</strong></p>
                <form action="purchaseFoodItem" method="post">
                    <input type="hidden" name="foodItemId" value="${foodItem.id}">
                    <input type="hidden" name="consumerId" value="${user.userId}">
                    <button type="submit">Purchase</button>
                </form>
            </div>
        </c:forEach>
    </section>
    
    <section>
        <h2>Subscription to Alerts</h2>
        <p>Get notified about new surplus food listings.</p>
        <form action="subscribeToAlerts" method="post">
            <input type="hidden" name="userId" value="${user.userId}">
            <button type="submit">Subscribe</button>
        </form>
    </section>
    
    <footer>
        <p>Consumer Dashboard © 2024</p>
    </footer>
</body>
</html>