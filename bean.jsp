<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Résultat JavaBean</title>
    <style>
        body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(135deg, #e0eafc 0%, #cfdef3 100%); display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; padding: 1.5rem; }
        .card { background: #fff; border-radius: 24px; padding: 2.5rem; box-shadow: 0 15px 35px rgba(0,0,0,0.1); text-align: center; max-width: 500px; width: 100%; }
        h2 { color: #2d3748; font-weight: 600; }
        table { width: 100%; border-collapse: collapse; margin-top: 1.5rem; border-radius: 12px; overflow: hidden; box-shadow: 0 4px 10px rgba(0,0,0,0.05); }
        th { background: #6366f1; color: white; padding: 1rem; text-align: left; }
        td { padding: 1rem; background: #f8fafc; border-bottom: 1px solid #e2e8f0; color: #334155; }
    </style>
</head>
<body>
    <div class="card">
        <h2>✨ Résultat du JavaBean</h2>

        <!-- 1. Instancier le Bean (s'il n'existe pas) -->
        <jsp:useBean id="person" class="isep.lab1.bean.Person" scope="request" />

        <!-- 2. Remplir automatiquement le Bean avec les paramètres de la requête -->
        <!-- L'étoile (*) dit : "Associe chaque paramètre du formulaire à l'attribut du bean qui a le même nom" -->
        <jsp:setProperty name="person" property="*" />

        <table>
            <tr>
                <th>Champ</th>
                <th>Valeur</th>
            </tr>
            <tr>
                <td>Prénom</td>
                <!-- 3. Récupérer et afficher les valeurs depuis le Bean -->
                <td><jsp:getProperty name="person" property="firstName" /></td>
            </tr>
            <tr>
                <td>Nom</td>
                <td><jsp:getProperty name="person" property="lastName" /></td>
            </tr>
            <tr>
                <td>Date de naissance</td>
                <td><jsp:getProperty name="person" property="birthDay" /></td>
            </tr>
            <tr>
                <td>Sexe</td>
                <td><jsp:getProperty name="person" property="sex" /></td>
            </tr>
        </table>

        <p style="margin-top: 2rem;">
            <a href="form-jsp.html" style="color: #6366f1; text-decoration: none; font-weight: bold;">⬅ Retour au formulaire</a>
        </p>
    </div>
</body>
</html>