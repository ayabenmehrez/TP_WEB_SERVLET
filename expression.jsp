<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>JSP - Expression</title>
    <style>
        * { box-sizing: border-box; }
        body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(135deg, #e0eafc 0%, #cfdef3 100%); display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; padding: 1.5rem; }
        .card { background: #fff; border-radius: 24px; padding: 2.5rem; box-shadow: 0 15px 35px rgba(0,0,0,0.1); text-align: center; max-width: 600px; width: 100%; }
        
        h2 { color: #2d3748; font-weight: 600; margin-top: 0; font-size: 1.8rem; display: flex; justify-content: center; align-items: center; gap: 15px; }
        .syntax-tag { font-family: monospace; font-size: 1.1rem; background: #fce7f3; color: #ec4899; padding: 0.3rem 0.8rem; border-radius: 8px; font-weight: bold; }

        .calc-box { background: #fdf2f8; color: #831843; padding: 1.5rem; border-radius: 16px; font-size: 1.1rem; margin: 2rem 0; text-align: left; border-left: 5px solid #ec4899; }
        .calc-box p { margin: 0.8rem 0; display: flex; justify-content: space-between; border-bottom: 1px dashed #fbcfe8; padding-bottom: 0.5rem; }
        .calc-box p:last-child { border-bottom: none; padding-bottom: 0; }
        .highlight { font-weight: bold; color: #be185d; }

        .back-link { display: inline-block; margin-top: 1rem; padding: 0.8rem 1.5rem; background: #6366f1; color: #fff; border-radius: 30px; text-decoration: none; font-weight: 600; transition: 0.3s; }
        .back-link:hover { background: #4f46e5; transform: translateY(-2px); }
    </style>
</head>
<body>
    <div class="card">
        <!-- La syntaxe est juste à côté du titre -->
        <h2>✨ Expression <span class="syntax-tag">&lt;%= ... %&gt;</span></h2>

        <% int a = 10; int b = 20; %>

        <div class="calc-box">
            <p><span>Calcul simple (5 + 3) :</span> <span class="highlight"><%= 5 + 3 %></span></p>
            <p><span>Somme des variables (<%= a %> + <%= b %>) :</span> <span class="highlight"><%= (a + b) %></span></p>
            <p><span>Méthode Java (toUpperCase) :</span> <span class="highlight"><%= "java servlet".toUpperCase() %></span></p>
        </div>

        <a href="index.html" class="back-link">🏠 Retour</a>
    </div>
</body>
</html>