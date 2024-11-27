<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login - Security Demo</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">Please Login</h2>
        <form action="<c:url value='/login'/>" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
        <div class="mt-3">
            <c:if test="${param.error != null}">
                <div class="alert alert-danger" role="alert">
                    Invalid username or password. Please try again.
                </div>
            </c:if>
            <c:if test="${param.logout != null}">
                <div class="alert alert-info" role="alert">
                    You have been logged out successfully.
                </div>
            </c:if>
        </div>
    </div>
</body>
</html>
