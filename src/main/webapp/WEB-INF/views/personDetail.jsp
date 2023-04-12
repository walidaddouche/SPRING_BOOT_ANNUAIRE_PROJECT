<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Person Details</title>
    <style><%@include file="../css/persons.css"%></style>
    <%@include file="navbar.jsp" %>


</head>
<body>
<h1>Person Details</h1>
<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Website</th>
        <th>Date of Birth</th>
        <th>Group Id</th>
    </tr>
    <tr>
        <td>${person.id}</td>
        <td>${person.firstName}</td>
        <td>${person.lastName}</td>
        <td>${person.email}</td>
        <td>${person.website}</td>
        <td>${person.dateOfBirth}</td>
        <td>${person.group.id}</td>
    </tr>
</table>
</body>
</html>
