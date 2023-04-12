<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reset Password</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }

        .container {
            margin: auto;
            padding: 20px;
            border: 1px solid #ccc;
            background-color: #fff;
            width: 400px;
        }

        form {
            display: grid;
            grid-template-columns: 1fr;
            grid-gap: 10px;
        }

        label {
            display: block;
            font-weight: bold;
        }

        input[type="text"], input[type="password"] {
            padding: 10px;
            border: none;
            border-radius: 5px;
            box-shadow: 1px 1px 1px #ccc;
        }

        button[type="submit"] {
            padding: 10px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        button[type="submit"]:hover {
            background-color: #3e8e41;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Reset Password</h2>
    <form:form method="post" action="reset-password" modelAttribute="resetPasswordForm">
        <label for="email">Email:</label>
        <form:input type="text" path="email" id="email" />


        <div class="error">${errorMessage}</div>

        <button type="submit">Submit</button>
    </form:form>
</div>
</body>
</html>
