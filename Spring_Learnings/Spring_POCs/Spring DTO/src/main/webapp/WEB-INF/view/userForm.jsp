<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>User Form</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .error {
            color: red; /* Styles the error messages */
            font-weight: bold;
        }
    </style>
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="mb-4">Enter User Details</h2>
    <form:form action="submitUser" modelAttribute="userDTO" method="post">
        <div class="form-group">
            <label>ID:</label>
            <form:input path="id" class="form-control" />
            <form:errors path="id" cssClass="error" />
        </div>

        <div class="form-group">
            <label>Name:</label>
            <form:input path="name" class="form-control" />
            <form:errors path="name" cssClass="error" />
        </div>

        <div class="form-group">
            <label>Email:</label>
            <form:input path="email" class="form-control" />
            <form:errors path="email" cssClass="error" />
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</div>
<!-- Optional JavaScript; choose one of the two! -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
