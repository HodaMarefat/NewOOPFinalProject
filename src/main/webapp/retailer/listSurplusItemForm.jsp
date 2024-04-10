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
        <h1>List a Surplus Food Item</h1>
    </header>
    
    <form action="listSurplusItem" method="POST">
        <div>
            <label for="foodItemId">Food Item ID:</label>
            <input type="text" id="foodItemId" name="foodItemId" required>
        </div>
        
        <div>
            <label>Status:</label>
            <input type="radio" id="forSale" name="status" value="forSale" required>
            <label for="forSale">For Sale</label>
            <input type="radio" id="forDonation" name="status" value="forDonation" required>
            <label for="forDonation">For Donation</label>
        </div>
        
        <div id="discountRateDiv" style="display:none;">
            <label for="discountRate">Discount Rate (for sales only):</label>
            <input type="text" id="discountRate" name="discountRate">
            <span>%</span>
        </div>
        
        <button type="submit">List Item</button>
    </form>
    
    <script>
        // JavaScript to toggle the display of the discount rate field based on status
        document.getElementById("forSale").addEventListener("change", function() {
            document.getElementById("discountRateDiv").style.display = "block";
        });
        document.getElementById("forDonation").addEventListener("change", function() {
            document.getElementById("discountRateDiv").style.display = "none";
        });
    </script>
    
    <footer>
        <p>© 2024 Retailer Dashboard</p>
    </footer>
</body>
</html>