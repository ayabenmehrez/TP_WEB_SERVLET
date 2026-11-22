<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>JSP - Déclaration</title>
    <style>
        * { box-sizing: border-box; }
        body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(135deg, #e0eafc 0%, #cfdef3 100%); display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; padding: 1.5rem; }
        .card { background: #fff; border-radius: 24px; padding: 2.5rem; box-shadow: 0 15px 35px rgba(0,0,0,0.1); text-align: center; max-width: 600px; width: 100%; }
        
        h2 { color: #2d3748; font-weight: 600; margin-top: 0; font-size: 1.8rem; display: flex; justify-content: center; align-items: center; gap: 15px; }
        .syntax-tag { font-family: monospace; font-size: 1.1rem; background: #ede9fe; color: #8b5cf6; padding: 0.3rem 0.8rem; border-radius: 8px; font-weight: bold; }

        ul { list-style: none; padding: 0; display: flex; flex-wrap: wrap; justify-content: center; gap: 0.8rem; margin: 2rem 0; }
        li { background: #8b5cf6; color: #fff; padding: 0.6rem 1.2rem; border-radius: 10px; font-weight: bold; font-size: 1.1rem; box-shadow: 0 4px 10px rgba(139,92,246,0.3); }
        
        .back-link { display: inline-block; margin-top: 1rem; padding: 0.8rem 1.5rem; background: #6366f1; color: #fff; border-radius: 30px; text-decoration: none; font-weight: 600; transition: 0.3s; }
        .back-link:hover { background: #4f46e5; transform: translateY(-2px); }
    </style>
</head>
<body>
    <div class="card">
        <!-- La syntaxe est juste à côté du titre -->
        <h2>📝 Déclaration <span class="syntax-tag">&lt;%! ... %&gt;</span></h2>

        <%! private int numEntries = 10;
        private int randomInt(int range) {
            return(1 + ((int)(Math.random() * range)));
        } %>
        
        <h3 style="color:#4a5568; margin-top:1rem;">🎲 A random list from 1 to 100:</h3>
        <ul>
        <% for(int i=0; i<numEntries; i++) {
            out.println("<li>" + randomInt(100) + "</li>");
        } %>
        </ul>

        <a href="index.html" class="back-link">🏠 Retour</a>
    </div>
</body>
</html>