<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Declaration</title>
</head>
<body>
<h3>--Welcome--</h3>
<h3>Use of Declaration in JSP</h3>
<%! int num1 = 2, num2 = 3, n = 0;%>
<%
  n = num1 + num2 + 1;
out.println("The number after adding declared variables is " + n);
%>
 
 
<%
        // Scriptlet to declare a variable
        String message = "Hello, JSP!";
        int number = 42;
    %>
 
    <p>Message: <%= message %></p>
    <p>Number: <%= number %></p>
 
    <%
        // Scriptlet for looping
        for (int i = 1; i <= 5; i++) {
    %>
        <p>Iteration: <%= i %></p>
    <%
        }%>
</body>
</html>