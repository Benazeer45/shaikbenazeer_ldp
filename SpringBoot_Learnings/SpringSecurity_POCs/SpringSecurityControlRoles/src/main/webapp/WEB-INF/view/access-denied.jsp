<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access Denied</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Access Denied</h1>
        <p>You are not authorized to access this page.</p>
        <a href="${pageContext.request.contextPath}/" class="btn btn-primary mt-3">Back to Home</a>
    </div>
</body>
</html>
