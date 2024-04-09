<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Waste Reduction Platform</title>
    <style>
        /* Basic styling for buttons and forms */
        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
            font-size: 16px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            outline: none;
            color: #fff;
            background-color: #4CAF50;
            border: none;
            border-radius: 15px;
            box-shadow: 0 9px #999;
        }

        .button:hover {background-color: #3e8e41}

        .button:active {
            background-color: #3e8e41;
            box-shadow: 0 5px #666;
            transform: translateY(4px);
        }

        .form-container {
            display: none;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <header>
    <h1>Food Waste Reduction Platform</h1>
    <div style="margin-bottom: 10px;">
        <a href="index">Home</a> |
        <a href="about-contact">About/Contact</a> |
        <a href="foodItem">Surplus Foods</a> |
        <a href="subscribe-alerts">Subscribe</a>
    </div>
    <div>
        <!-- Updated links for navigation -->
        <a href="login" class="button">Login</a>
        <a href="register" class="button">Register</a>
        
    </div>
    </header>

    <footer>
        <p>Food Waste Reduction Platform © 2024</p>
    </footer>
</body>
</html>
