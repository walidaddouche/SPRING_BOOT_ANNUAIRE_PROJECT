<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <th>members size</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="group" items="${groups}">
        <tr id="${group.id}">
            <td>${group.id}</td>
            <td>${group.name}</td>
            <td>${personRepository.countPersonsByGroup(group)}</td>
        </tr>
    </c:forEach>


    <script>
        var table = document.querySelector('table');
        table.addEventListener('click', function(event) {
            var id = event.target.parentNode.id;
            if (id) {
                window.location.href = '/groups/' + id;
            }
        });
    </script>

    </tbody>
</table>
</body>
</html>
