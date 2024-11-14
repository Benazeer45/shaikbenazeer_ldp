<%@ page import="java.util.List" %>
<%@ page import="org.example.Entity.Customer" %>

<!DOCTYPE html>
<html>
<head>
    <title>Customer List</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script>
        // JavaScript function to open the modal and set the customerId
        function confirmDelete(customerId) {
            // Set the customerId in the modal
            document.getElementById("confirmDeleteBtn").onclick = function() {
                // Redirect to the delete URL when confirmed
                window.location.href = "deleteCustomer?customerId=" + customerId;
            };
            // Show the modal
            $('#deleteModal').modal('show');
        }
    </script>
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h1 class="text-center mb-4 display-4 font-weight-bold">Customer List</h1>

        <input type="button" value="Add Customer"
               onclick="window.location.href= 'showFormForAdd'; return false;"
               class="btn btn-secondary mb-3" />

        <table class="table table-bordered table-striped table-hover">
            <thead class="bg-success text-white">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Customer> customers = (List<Customer>) request.getAttribute("customers");
                    if (customers != null) {
                        for (Customer customer : customers) {
                %>
                <tr>
                    <td><%= customer.getFirstName() %></td>
                    <td><%= customer.getLastName() %></td>
                    <td><%= customer.getEmail() %></td>
                    <td>
                        <a href="showFormForUpdate?customerId=<%= customer.getId() %>" class="btn btn-primary">Update</a>
                        <!-- Modify the Delete link to use the JavaScript function -->
                        <a href="javascript:void(0);" class="btn btn-danger" onclick="confirmDelete(<%= customer.getId() %>)">Delete</a>
                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5" class="text-center text-muted">No customers available</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>

    <!-- Modal for delete confirmation -->
    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteModalLabel">Confirm Deletion</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure you want to delete this customer? This action cannot be undone.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" id="confirmDeleteBtn" class="btn btn-danger">Delete</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Optional JavaScript; choose one of the two! -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
