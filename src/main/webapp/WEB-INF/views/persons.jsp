<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Person Details</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {background-color: #f2f2f2;}

        tr:hover {background-color: #ddd;}

        td:first-child {
            font-weight: bold;
        }

        td span {
            font-style: italic;
        }

    </style>
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
