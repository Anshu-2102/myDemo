<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <h2>Welcome, ${myname}!</h2>
 
    <p>Company name is: ${company}</p>
 
    <!-- Use of the PageContext implicit object -->
    <p>Using PageContext to get request attribute:</p>
    <%
        // Accessing request and session attributes using PageContext
        String unameFromRequest = (String) pageContext.getAttribute("myname", PageContext.REQUEST_SCOPE);
        String companyFromRequest = (String) pageContext.getAttribute("company", PageContext.REQUEST_SCOPE);
    %>
 
    <p>Retrieved 'uname' from request scope using PageContext: <%= unameFromRequest %></p>
    <p>Retrieved 'driverName' from request scope using PageContext: <%= companyFromRequest %></p>
 
  
    <%
        // Accessing application-level attributes
        String appAttribute = (String) pageContext.getServletContext().getAttribute("appAttribute");
    %>
 
  
 
</body>
</html>