
  <head>
    <meta charset="UTF-8">
    <title>README</title>
  </head>
  <body>
    <h1>SPRING_BOOT_ANNUAIRE_PROJECT</h1>
    <p>SPRING_BOOT_ANNUAIRE_PROJECT est un projet Spring Boot conçu pour gérer un annuaire d'utilisateurs.</p>
    <h2>Installation</h2>
    <p>Pour installer le projet, vous devez d'abord cloner le dépôt Git en utilisant la commande suivante:</p>
    <pre><code>git clone https://github.com/walidaddouche/SPRING_BOOT_ANNUAIRE_PROJECT.git</code></pre>
    <p>Ensuite, vous pouvez importer le projet dans votre IDE préféré (Eclipse, IntelliJ, etc.) en tant que projet Maven.</p>
    <p>Pour générer le fichier JAR, vous devez exécuter la commande suivante à partir de la racine du projet:</p>
    <pre><code>mvn clean package</code></pre>
    <h2>Utilisation</h2>
    <p>Après avoir généré le fichier JAR, vous pouvez l'exécuter en utilisant la commande suivante:</p>
    <pre><code>java -jar target/SPRING_BOOT_ANNUAIRE_PROJECT-1.0.jar</code></pre>
    <p>L'application sera alors accessible depuis votre navigateur web à l'adresse suivante: http://localhost:8080/</p>
    <h2>Fonctionnalités</h2>
    <p>L'application permet aux utilisateurs de:</p>
    <ul>
      <li>Ajouter, modifier et supprimer des utilisateurs de l'annuaire</li>
      <li>Chercher des utilisateurs dans l'annuaire en fonction de leur nom ou de leur prénom</li>
      <li>Se connecter à l'application en utilisant un compte d'utilisateur enregistré</li>
      <li>Récupérer un mot de passe perdu en utilisant leur adresse e-mail</li>
    </ul>
    <h2>Architecture technique</h2>
    <p>L'application suit le pattern MVC (Modèle-Vue-Contrôleur) pour une séparation claire des responsabilités. La couche modèle gère les données, la couche vue présente les données à l'utilisateur et la couche contrôleur gère les interactions entre la couche modèle et la couche vue. En complément, une couche de services a été mise en place pour encapsuler la logique métier de l'application. Cette couche de services est responsable de traiter les données provenant de la couche modèle et de les préparer pour la couche vue. Elle permet également de gérer les sessions pour les utilisateurs authentifiés, l'envoi d'e-mails pour la récupération de mot de passe et la notification d'événements importants.</p>
    <h2>Package</h2>
    <p>Le package de l'application est "com.app".</p>
    <h2>Auteur</h2>
    <p>SPRING_BOOT_ANNUAIRE_PROJECT a été développé par Walid Addouche.</p>
  </body>
