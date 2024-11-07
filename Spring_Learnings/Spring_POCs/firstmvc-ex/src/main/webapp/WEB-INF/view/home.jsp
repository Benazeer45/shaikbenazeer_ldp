<%@page isELIgnored="false"%>
<html>
<body>
    <h1>Welcome, ${name}!</h1>
    <h2>Your ID is ${id}</h2>
    <h3>Your friends:</h3>
    <ul>
        <c:forEach var="friend" items="${friends}">
            <li>${friend}</li>
        </c:forEach>
    </ul>
</body>
</html>
