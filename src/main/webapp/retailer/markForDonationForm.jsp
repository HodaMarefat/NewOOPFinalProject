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
        <h1>Mark Food Item for Donation</h1>
    </header>
    
    <form action="markForDonation" method="POST">
        <div>
            <label for="foodItemId">Food Item ID:</label>
            <input type="text" id="foodItemId" name="foodItemId" required>
        </div>
        
        <button type="submit">Mark for Donation</button>
    </form>
    
    <footer>
        <p>© 2024 Retailer Dashboard</p>
    </footer>
</body>
</html>