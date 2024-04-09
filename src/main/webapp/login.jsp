<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Waste Reduction Platform - Login</title>
</head>
<body>
    <header>
        <h1>Food Waste Reduction Platform</h1>
        <div style="margin-bottom: 10px;">
            <a href="index.jsp">Home</a> |
            <a href="about-contact.jsp">About/Contact</a> |
            <a href="foodItem.jsp">Surplus Foods</a> |
            <a href="subscribe-alerts.jsp">Subscribe</a>
        </div>
    </header>
    
    <div>
        <% if (request.getAttribute("loginError") != null) { %>
            <p style="color: red; font-weight: bold;"><%= request.getAttribute("loginError") %></p>
        <% } %>
        <form method="post" action="login" >
            <label for="email">Email:</label>
            <input type="text" id="email" name="email"><br>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"><br>
            
            <input type="submit" value="Login">
        </form>
    </div>
</body>
</html>
