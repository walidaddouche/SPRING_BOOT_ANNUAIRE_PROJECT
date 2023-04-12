<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Erreur</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            width: 70%;
            margin: 0 auto;
            margin-top: 50px;
            text-align: center;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            padding: 30px;
        }

        h1 {
            font-size: 2.5rem;
            margin-bottom: 20px;
            color: #333;
        }

        p {
            font-size: 1.2rem;
            line-height: 1.5;
            color: #666;
            margin-bottom: 30px;
        }


    </style>
</head>
<header>
    <%@include file="navbar.jsp" %>

</header>
<body>
<div class="container">
    <h1>Erreur 404</h1>
    <p>Page Introuvable.</p>
    <a href="/">Retour agi l'accueil</a>
</div>
</body>
</html>
