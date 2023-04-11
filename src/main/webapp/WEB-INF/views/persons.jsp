<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Person Details</title>
    <style><%@include file="../css/persons.css"%></style>

</head>
<body>
<h1>Person Details</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Website</th>
        <th>Date of Birth</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="person" items="${persons}">
        <tr>
            <td>${person.id}</td>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.email}</td>
            <td>${person.website}</td>
            <td>${person.dateOfBirth}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
