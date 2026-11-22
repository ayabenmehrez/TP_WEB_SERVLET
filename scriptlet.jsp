<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>JSP - Scriptlet</title>
    <style>
        * { box-sizing: border-box; }
        body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(135deg, #e0eafc 0%, #cfdef3 100%); display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; padding: 1.5rem; }
        .card { background: #fff; border-radius: 24px; padding: 2.5rem; box-shadow: 0 15px 35px rgba(0,0,0,0.1); text-align: center; max-width: 600px; width: 100%; }
        
        /* Le titre et son étiquette de syntaxe */
        h2 { color: #2d3748; font-weight: 600; margin-top: 0; font-size: 1.8rem; display: flex; justify-content: center; align-items: center; gap: 15px; }
        .syntax-tag { font-family: monospace; font-size: 1.1rem; background: #e2e8f0; color: #3b82f6; padding: 0.3rem 0.8rem; border-radius: 8px; font-weight: bold; }
        
        .result-box { background: #eff6ff; color: #1e3a8a; padding: 1.5rem; border-radius: 16px; font-size: 1.1rem; margin: 2rem 0; text-align: left; border-left: 5px solid #3b82f6; }
        .result-box p { margin: 0.8rem 0; }
        
        .back-link { display: inline-block; margin-top: 1rem; padding: 0.8rem 1.5rem; background: #6366f1; color: #fff; border-radius: 30px; text-decoration: none; font-weight: 600; transition: 0.3s; }
        .back-link:hover { background: #4f46e5; transform: translateY(-2px); }
    </style>
</head>
<body>
    <div class="card">
        <!-- La syntaxe est juste à côté du titre -->
        <h2>⚙️ Scriptlet <span class="syntax-tag">&lt;% ... %&gt;</span></h2>

        <%
            Date dateActuelle = new Date();
            String adresseIP = request.getRemoteHost();
        %>

        <div class="result-box">
            <p>🕒 <strong>Heure actuelle :</strong> <%= dateActuelle.toString() %></p>
            <p>🌐 <strong>Adresse IP :</strong> <%= adresseIP %></p>
        </div>

        <a href="index.html" class="back-link">🏠 Retour</a>
    </div>
</body>
</html>