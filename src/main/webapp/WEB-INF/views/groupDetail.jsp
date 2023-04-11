<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Group Details</title>
    <style><%@include file="../css/groupes.css"%></style>
</head>
<body>
<h1>Group Details</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>

    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${group.id}</td>
        <td>${group.name}</td>

    </tr>
    </tbody>
</table>
<h2>Members:</h2>
<table>
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Date of Birth</th>
        <th>Email</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="person" items="${persons}">
        <tr>
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.dateOfBirth}</td>
            <td>${person.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
