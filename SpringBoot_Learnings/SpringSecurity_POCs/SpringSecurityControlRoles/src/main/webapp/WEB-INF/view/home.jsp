<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home - Security Demo</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">Welcome to the Company Page!</h2>
        <p class="mt-3">
            Hello, <strong>${username}</strong>! You are logged in with the role(s):
            <strong>${roles}</strong>.
        </p>

        <!-- Conditional links based on roles -->
        <div class="mt-4">
            <%-- Display link for Manager --%>
            <c:if test="${roles.contains('ROLE_MANAGER')}">
                <a href="manager" class="btn btn-primary">Go to Manager Page</a>
            </c:if>

            <%-- Display link for Admin --%>
            <c:if test="${roles.contains('ROLE_ADMIN')}">
                <a href="admin" class="btn btn-danger">Go to Admin Page</a>
            </c:if>
        </div>

        <!-- Logout button -->
        <div class="mt-4">
            <form action="${pageContext.request.contextPath}/logout" method="POST">
                <button type="submit" class="btn btn-warning">Logout</button>
            </form>

        </div>
    </div>
</body>
</html>
