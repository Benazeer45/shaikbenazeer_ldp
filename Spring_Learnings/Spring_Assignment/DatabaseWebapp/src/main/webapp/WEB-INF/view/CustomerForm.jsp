<%@ page import="org.example.entity.Customer" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add/Edit Customer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="bg-light">
    <main class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <h1 class="text-center mb-4">Add/Edit Customer</h1>

                <form action="saveCustomer" method="post">
                    <input type="hidden" name="id" value="${customer.id}" /> <!-- Hidden ID field -->

                    <div class="form-group">
                        <label for="firstName" class="font-weight-bold">First Name:</label>
                        <input type="text" id="firstName" name="firstName"
                               value="${customer.firstName}" required
                               class="form-control" placeholder="Enter first name" />
                    </div>

                    <div class="form-group">
                        <label for="lastName" class="font-weight-bold">Last Name:</label>
                        <input type="text" id="lastName" name="lastName"
                               value="${customer.lastName}" required
                               class="form-control" placeholder="Enter last name" />
                    </div>

                    <div class="form-group">
                        <label for="email" class="font-weight-bold">Email:</label>
                        <input type="email" id="email" name="email"
                               value="${customer.email}" required
                               class="form-control" placeholder="Enter email address" />
                    </div>

                    <div class="form-row mt-4">
                        <div class="col">
                            <button type="submit" class="btn btn-primary btn-block">Save Customer</button>
                        </div>
                        <div class="col">
                            <a href="${pageContext.request.contextPath}/customer/list" class="btn btn-secondary btn-block">Back to Customer List</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </main>
</body>
</html>
