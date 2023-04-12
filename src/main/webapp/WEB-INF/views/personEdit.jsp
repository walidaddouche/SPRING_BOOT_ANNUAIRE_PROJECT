<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Edit Person</title>
</head>
<body>
<h1>Edit Person</h1>
<style><%@include file="../css/personEdit.css"%></style>

<form:form method="POST" modelAttribute="person" action="/persons/save">
    <table>
        <tr>
            <td><form:label path="id">id</form:label></td>
            <td><form:textarea  readonly="true" path="id"/></td>
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
                <input type="submit" value="Save"/>
            </td>
        </tr>
    </table>
</form:form>


</body>
</html>
