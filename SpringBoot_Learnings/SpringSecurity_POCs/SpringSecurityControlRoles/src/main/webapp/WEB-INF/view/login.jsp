<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">Login</h2>
        <form action="<c:url value='/login' />" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>

        <!-- Display error message if login failed -->
        <c:if test="${param.error != null}">
            <div class="alert alert-danger mt-3">
                <strong>Error!</strong> Invalid username or password.
            </div>
        </c:if>

        <!-- Display message if login is successful but the user was redirected to login -->
        <c:if test="${param.logout != null}">
            <div class="alert alert-success mt-3">
                <strong>Logged out successfully!</strong>
            </div>
        </c:if>
    </div>
</body>
</html>
