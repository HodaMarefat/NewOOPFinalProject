<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.fwrp.model.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to the Food Waste Reduction Platform</title>
</head>
<body>
    <div class="container">
        <h1>Welcome to the Food Waste Reduction Platform</h1>
        <%
            User user = (User) request.getSession(false).getAttribute("user");
            if (user != null) {
                out.println("<p>Hello, " + user.getUserName() + "!</p>");
            }
        %>
        <p>Thank you for joining us in our effort to reduce food waste. You are now logged in and can access all the features of the platform.</p>
        <p><a href="logout.jsp">Logout</a></p>
    </div>
</body>
</html>
