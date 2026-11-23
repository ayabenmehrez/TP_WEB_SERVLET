<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Jeune</title>
    <style>
        body { font-family: 'Segoe UI', sans-serif; text-align: center; padding: 3rem; background: #e0eafc; }
        .card { background: white; border-radius: 20px; padding: 2rem; max-width: 500px; margin: auto; box-shadow: 0 10px 25px rgba(0,0,0,0.1); }
        h2 { color: #1e3a8a; }
    </style>
</head>
<body>
    <div class="card">
        <h2>👦 Bienvenue (Né après 1990)</h2>
        
        <jsp:useBean id="person" type="lab.mvc.model.Person" scope="request" />
        
        <p>Prénom : <strong><jsp:getProperty name="person" property="firstName" /></strong></p>
        <p>Nom : <strong><jsp:getProperty name="person" property="lastName" /></strong></p>
        <p>Date de naissance : <strong><jsp:getProperty name="person" property="birthDay" /></strong></p>
        <p>Sexe : <strong><jsp:getProperty name="person" property="sex" /></strong></p>
        
        <a href="index.html">Retour</a>
    </div>
</body>
</html>