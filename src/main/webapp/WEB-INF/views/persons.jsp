<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Person </title>
    <style><%@include file="../css/persons.css"%></style>
    <%@include file="navbar.jsp" %>



</head>
<body>
<h1> Persons </h1>
<table>
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="person" items="${persons}">
        <tr id="${person.id}">
            <td>${person.firstName}</td>
            <td>${person.lastName}</td>
            <td>${person.email}</td>
        </tr>
    </c:forEach>
    </tbody>

    <script>
        var table = document.querySelector('table');
        table.addEventListener('click', function(event) {
            var id = event.target.parentNode.id;
            if (id) {
                window.location.href = '/persons/' + id;
                console.log(id)
            }
        });
    </script>

</table>
</body>
</html>
