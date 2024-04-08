<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            display: none; /* Initially hide all items */
        }
        .item h3 {
            color: #4CAF50;
        }
    </style>
</head>
<body>
    <header>
        <h1>Surplus Food Listings</h1>
        <nav>
            <button onclick="filterItems('All')">All Items</button>
            <button onclick="filterItems('For Sale')">For Sale</button>
            <button onclick="filterItems('For Donation')">For Donation</button>
        </nav>
    </header>

    <div class="container">
        <%-- Dynamic item generation could go here --%>
        <!-- Static examples for now -->
        <div class="item" data-status="For Sale">
            <h3>Item Name: Apples</h3>
            <p>Description: Fresh Green Apples</p>
            <p>Quantity: 100</p>
            <p>Status: For Sale</p>
        </div>
        
        <div class="item" data-status="For Donation">
            <h3>Item Name: Bread</h3>
            <p>Description: Whole wheat bread</p>
            <p>Quantity: 50</p>
            <p>Status: For Donation</p>
        </div>

        <div class="item" data-status="For Sale">
            <h3>Item Name: Milk</h3>
            <p>Description: 2% Milk Carton</p>
            <p>Quantity: 30</p>
            <p>Status: For Sale</p>
        </div>
<div class="item" data-status="For Sale">
        <h3>Item Name: Potatoes</h3>
        <p>Description: Organic Potatoes</p>
        <p>Quantity: 40</p>
        <p>Status: For Sale</p>
    </div>

    <div class="item" data-status="For Sale">
        <h3>Item Name: Carrots</h3>
        <p>Description: Crunchy Carrots</p>
        <p>Quantity: 50</p>
        <p>Status: For Sale</p>
    </div>

    <div class="item" data-status="For Sale">
        <h3>Item Name: Lettuce</h3>
        <p>Description: Green Lettuce</p>
        <p>Quantity: 70</p>
        <p>Status: For Sale</p>
    </div>

    <div class="item" data-status="For Sale">
        <h3>Item Name: Peppers</h3>
        <p>Description: Bell Peppers</p>
        <p>Quantity: 55</p>
        <p>Status: For Sale</p>
    </div>

    <!-- For Donation items -->
    <div class="item" data-status="For Donation">
        <h3>Item Name: Bananas</h3>
        <p>Description: Ripe Bananas</p>
        <p>Quantity: 30</p>
        <p>Status: For Donation</p>
    </div>

    <div class="item" data-status="For Donation">
        <h3>Item Name: Cucumbers</h3>
        <p>Description: Fresh Cucumbers</p>
        <p>Quantity: 25</p>
        <p>Status: For Donation</p>
    </div>

    <div class="item" data-status="For Donation">
        <h3>Item Name: Zucchini</h3>
        <p>Description: Organic Zucchini</p>
        <p>Quantity: 45</p>
        <p>Status: For Donation</p>
    </div>

    <div class="item" data-status="For Donation">
        <h3>Item Name: Spinach</h3>
        <p>Description: Fresh Spinach</p>
        <p>Quantity: 35</p>
        <p>Status: For Donation</p>
    </div>
	<div class="item" data-status="For Donation">
        <h3>Item Name: Spaghetti</h3>
        <p>Description: Italian Spaghetti</p>
        <p>Quantity: 35</p>
        <p>Status: For Donation</p>
    </div>
    </div>

    <footer>
        <p>Food Waste Reduction Platform © 2024</p>
    </footer>

    <script>
        function filterItems(status) {
            const items = document.querySelectorAll('.item');
            items.forEach(item => {
                if (status === 'All' || item.getAttribute('data-status') === status) {
                    item.style.display = 'block';
                } else {
                    item.style.display = 'none';
                }
            });
        }

        // Initialize page with all items visible
        window.onload = () => filterItems('All');
    </script>
</body>
</html>
