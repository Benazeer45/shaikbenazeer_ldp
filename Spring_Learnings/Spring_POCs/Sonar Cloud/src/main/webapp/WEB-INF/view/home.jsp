<%@ page import="java.util.List" %>
<html>
<body>
    <h1>Hello World!...welcome to home page</h1>
    <%
        String name = (String) request.getAttribute("name");
        Integer id = (Integer) request.getAttribute("id");
        List<String> friends = (List<String>) request.getAttribute("f");
    %>
    <h2> Hello <%= name %> </h2>
    <h2> Your Id is <%= id %> </h2>
    <ul>
        <%
            if (friends != null) {
                for (String friend : friends) {
        %>
                    <li><%= friend %></li>
        <%
                }
            }
        %>
    </ul>
</body>
</html>
