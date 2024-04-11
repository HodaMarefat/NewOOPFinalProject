<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Charity Organization Dashboard</title>
    
</head>
<body>
    <header>
        <h1>Charity Organization Dashboard</h1>
        <nav>
            <a href="index.jsp">Home</a> |
            <a href="about-contact.jsp">About/Contact</a> |
            <a href="foodItem">Surplus Foods</a> |
            <a href="subscribe-alerts.jsp">Subscribe</a>
        </nav>
    </header>
    
    <section>
        <h2>Claimable Food Donations</h2>
        <!-- List of food items available for donation -->
        <p>Browse and claim food items listed for donation by retailers.</p>
        <c:forEach var="foodItem" items="${donatableFoodItems}">
            <div>
                <p>${foodItem.name}</p>
                <form action="claimFoodItem" method="post">
                    <input type="hidden" name="foodItemId" value="${foodItem.id}">
                    <input type="hidden" name="organizationId" value="${user.userId}">
                    <button type="submit">Claim</button>
                </form>
            </div>
        </c:forEach>
    </section>
    
    <section>
        <h2>Alert Subscriptions</h2>
        <!-- Subscription form for alerts on new donation items -->
        <form action="subscribeToAlerts" method="post">
            <input type="hidden" name="userId" value="${user.userId}">
            <button type="submit">Subscribe to Donation Alerts</button>
        </form>
    </section>
    
    <footer>
        <p>Charity Organization Dashboard © 2024</p>
    </footer>
</body>
</html>
