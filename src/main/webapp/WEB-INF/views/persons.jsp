<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>Person </title>
    <style><%@include file="../css/persons.css"%></style>


    <script>
        function search() {
            var input, filter, table, tr, td, i, txtValue;
            input = document.getElementById("searchBar");
            filter = input.value.toUpperCase();
            table = document.getElementById("personsTable");
            tr = table.getElementsByTagName("tr");
            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[0];
                if (td) {
                    txtValue = td.textContent || td.innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }
            }
        }
    </script>
</head>

<header>
    <%@include file="navbar.jsp" %>

</header>
<body>

<div class="search-bar-container">
<input type="text" id="searchBar" onkeyup="search()" placeholder="Search by first name...">
</div>
<h1> Persons </h1>
<table id="personsTable">
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
