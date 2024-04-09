<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About/Contact - Food Waste Reduction Platform</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .container { width: 80%; margin: auto; }
        .contact-form { margin-top: 20px; }
        label, input, textarea { display: block; width: 100%; margin-top: 10px; }
        input, textarea { padding: 10px; }
        button { padding: 10px 20px; margin-top: 10px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>About the Food Waste Reduction Platform</h1>
        <p>
            The Food Waste Reduction Platform is dedicated to connecting food retailers, consumers, and charitable organizations to efficiently redistribute surplus food. Our mission is to reduce food waste and support communities by providing access to nutritious food that would otherwise go to waste.
        </p>
        
        <h2>Contact Us</h2>
        <p>If you have any questions, suggestions, or would like to collaborate with us, please fill out the form below or reach out via the contact details provided.</p>
        
        <div class="contact-form">
            <form action="sendInquiry.jsp" method="post">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
                
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
                
                <label for="message">Message:</label>
                <textarea id="message" name="message" rows="6" required></textarea>
                
                <button type="submit">Send Message</button>
            </form>
        </div>
        
        <h2>Additional Contact Information</h2>
        <p>Email: contact@fwrplatform.org</p>
        <p>Phone: +123 456 7890</p>
        <p>Address: 123 Food Waste Avenue, Sustainability City, Earth</p>
    </div>
</body>
</html>
