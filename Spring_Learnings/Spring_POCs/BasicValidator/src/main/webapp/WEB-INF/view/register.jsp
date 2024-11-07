<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Registration</title>
    <style>
        .error {
            color: red; /* Styles the error messages */
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1>User Registration</h1>
    <form:form action="register" modelAttribute="user" method="post">
        <div>
            <label for="firstName">First Name:</label>
            <form:input path="firstName" id="firstName"/>
            <form:errors path="firstName" cssClass="error"/>
        </div>
        <div>
            <label for="lastName">Last Name:</label>
            <form:input path="lastName" id="lastName"/>
            <form:errors path="lastName" cssClass="error"/>
        </div>
        <div>
            <label for="age">Age:</label>
            <form:input path="age" id="age" type="number"/>
            <form:errors path="age" cssClass="error"/>
        </div>
        <div>
            <label for="email">Email:</label>
            <form:input path="email" id="email"/>
            <form:errors path="email" cssClass="error"/>
        </div>
        <div>
            <input type="submit" value="Register"/>
        </div>
    </form:form>
</body>
</html>
