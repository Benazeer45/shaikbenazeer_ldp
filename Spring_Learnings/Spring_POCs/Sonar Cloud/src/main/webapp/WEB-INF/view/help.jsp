<%@ page import="java.time.LocalDateTime" %>
<%@page isELIgnored="false"%>
<html>
<body>
<h2>Welcome to Help Page</h2>
<%
String name=(String)request.getAttribute("name");
Integer rollnumber=(Integer)request.getAttribute("rollnumber");
LocalDateTime time=(LocalDateTime)request.getAttribute("time");
%>
<h1> Hello my surname is <%=name%></h1>
<h2> This is help page </h2>
<h3> My role number is <%=rollnumber%></h3>
<h4> Date and Time is <%=time.toString()%></h4>
</body>
</html>

<!-- Converted to Java Expression Language (EL) -->

<html>
<body>
    <h2>Welcome to Help Page</h2>
    <h1>Hello my surname is ${name}</h1>
    <h2>This is the help page</h2>
    <h3>My roll number is ${rollnumber}</h3>
    <h4>Date and Time is ${time}</h4>
</body>
</html>
