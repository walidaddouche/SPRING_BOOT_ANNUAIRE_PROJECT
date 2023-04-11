<!DOCTYPE html>
<html>
<head>
    <title>Annuaire</title>
    <style>
        body {
            background-color: white;
        }

        h1 {
            font-size: 45px;
            color: green;
            text-align: center;
            margin-top: 50px;
        }

        form {
            text-align: center;
            margin-top: 50px;
        }

        small {
            display: block;
            text-align: center;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<h1>Annuaire</h1>
<form action="/home" method="post">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>
    <button type="submit">Login</button>
</form>
<small>projet jee zidani addouche 2023</small>
</body>
</html>