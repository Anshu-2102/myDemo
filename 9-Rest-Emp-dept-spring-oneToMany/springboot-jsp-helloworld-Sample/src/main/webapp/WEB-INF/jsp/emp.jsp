<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Profile</title>
</head>
<body>
 
    <h2>Employee Profile</h2>
 
    <!-- UseBean Tag to instantiate and access the Employee Bean -->
    <jsp:useBean id="employeeBean" class="com.cg.model.Employee" scope="request" />
    
    <!-- Set values using setProperty -->
    <jsp:setProperty name="employeeBean" property="id" value="${employee.id}" />
    <jsp:setProperty name="employeeBean" property="name" value="${employee.name}" />
    <jsp:setProperty name="employeeBean" property="email" value="${employee.email}" />
 
    <!-- Get properties of the bean -->
    <p>ID: <jsp:getProperty name="employeeBean" property="id" /></p>
    <p>Name: <jsp:getProperty name="employeeBean" property="name" /></p>
    <p>Email: <jsp:getProperty name="employeeBean" property="email" /></p>
 
    <h3>Direct access to Employee properties from the Model:</h3>
    <p>ID: ${employee.id}</p>
    <p>Name: ${employee.name}</p>
    <p>Email: ${employee.email}</p>
 
</body>
</html>