<!-- /WEB-INF/jsp/testResponse.jsp -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Test Response Object</title>
</head>
<body>
    <h1>Response Content Test</h1>
    
    <!-- Display the response message passed from the controller -->
    <p>${responseMessage}</p>
 
    <h2>Response Details:</h2>
    
    <p><strong>Content-Type:</strong> ${responseContentType}</p>
    <p><strong>Status Code:</strong> ${responseStatus}</p>
    <p><strong>Custom Header (X-Custom-Header):</strong> ${customHeader}</p>
 
    <p>This content was written directly to the response output stream.</p>
</body>
</html>