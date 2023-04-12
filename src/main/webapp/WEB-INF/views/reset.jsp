<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enter Email Address</title>
</head>
<body>
<h1>Enter Email Address</h1>

<form:form method="POST" modelAttribute="person" action="/email/submitEmail">
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
                <input type="submit" value="Save"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
