<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des groupes</title>
    <style><%@include file="../css/groupes.css"%></style>

</head>
<body>
<h1>Liste des groupes</h1>

<table>
    <thead>
    <tr>
        <th>Nom du groupe</th>
        <th>Membres</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="group" items="${groups}">
        <tr>
            <td>${group.name}</td>
            <td>
                <ul>
                    <c:forEach var="person" items="${group.people}">
                        <li>${person.firstName} ${person.lastName}</li>
                    </c:forEach>
                </ul>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
