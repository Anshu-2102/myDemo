<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
 
<h2>Login</h2>
<form action="/login" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required />
    <br/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required />
    <br/>
    <button type="submit">Login</button>
</form>
 
<!-- Here we will include another page -->
<jsp:include page="includePage.jsp" />
 
</body>
</html>