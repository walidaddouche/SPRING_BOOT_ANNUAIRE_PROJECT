<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Person</title>
</head>
<body>
<header>
    <%@include file="navbar.jsp" %>

</header>
<h1>Edit Person</h1>
<style>
    <%@include file="../css/personEdit.css" %>
</style>



<form:form method="POST" modelAttribute="person" action="edit">
    <table>
        <tr>
            <td><form:label path="id">id</form:label></td>
            <td><form:textarea readonly="true" path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="firstName">First Name</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Last Name</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><form:label path="website">Website</form:label></td>
            <td><form:input path="website"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save" onsubmit="showSuccessMessage()"/>
                <div class="success">${successMessage}</div>

            </td>
        </tr>
    </table>
</form:form>

<script>
    function showSuccessMessage() {
        let messageDiv = document.getElementsByClassName("successMessage");
        messageDiv.innerHTML = "Vos informations ont bien été modifiées";
        messageDiv.style.display = "block";
    }
</script>


</body>
</html>
