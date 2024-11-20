<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
    <h1>Add Employee</h1>
    <form action="${pageContext.request.contextPath}/employees/submit" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required/><br/>

        <label for="department">Department:</label>
        <input type="text" id="department" name="department"/><br/>

        <button type="submit">Add Employee</button>
    </form>
</body>
</html>
