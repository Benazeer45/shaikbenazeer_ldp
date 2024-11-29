<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout - Security Demo</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">You have been logged out successfully.</h2>
        <a href="<c:url value='/login'/>" class="btn btn-primary mt-3">Login Again</a>
    </div>
</body>
</html>
