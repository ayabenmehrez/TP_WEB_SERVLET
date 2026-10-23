package ex1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListItems extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Récupérer la session
        HttpSession session = request.getSession();

        // 2. Récupérer ou créer la HashMap (compteur par item unique)
        @SuppressWarnings("unchecked")
        HashMap<String, Integer> counts = (HashMap<String, Integer>) session.getAttribute("counts");
        if (counts == null) {
            counts = new HashMap<>();
        }

        // 3. Ajouter le nouvel item (incrémentation du compteur)
        String newItem = request.getParameter("newItem");
        if (newItem != null && !newItem.trim().isEmpty()) {
            newItem = newItem.trim();
            counts.put(newItem, counts.getOrDefault(newItem, 0) + 1);
        }

        // 4. Sauvegarder en session
        session.setAttribute("counts", counts);

        // 5. Afficher la liste (une seule ligne par item unique)
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html><html lang='fr'><head><meta charset='UTF-8'>");
        out.println("<title>Liste des items</title>");
        out.println("<style>");
        out.println("body{font-family:'Segoe UI',sans-serif;background:#f5f7fb;"
                  + "display:flex;justify-content:center;align-items:center;"
                  + "min-height:100vh;margin:0;padding:1.5rem;}");
        out.println(".card{background:#fff;border-radius:24px;padding:2rem;"
                  + "box-shadow:0 20px 35px -8px rgba(0,20,30,0.2);"
                  + "width:100%;max-width:500px;}");
        out.println("h1{color:#0b2b3c;font-weight:500;}");
        out.println("ul{list-style:none;padding:0;}");
        out.println("li{background:#f0f6fa;padding:0.7rem 1rem;margin:0.4rem 0;"
                  + "border-radius:10px;display:flex;justify-content:space-between;"
                  + "align-items:center;}");
        out.println(".badge{background:#0077be;color:#fff;padding:0.2rem 0.7rem;"
                  + "border-radius:20px;font-size:0.85rem;font-weight:600;}");
        out.println("a{color:#0077be;font-weight:600;text-decoration:none;"
                  + "display:inline-block;margin-top:1rem;}"
                  + "a:hover{text-decoration:underline;}");
        out.println("</style></head><body><div class='card'>");
        out.println("<h1>📝 Vos items</h1>");

        if (counts.isEmpty()) {
            out.println("<p><em>Aucun item pour le moment.</em></p>");
        } else {
            out.println("<ul>");
            // ⚠️ CORRECTION : on parcourt counts.keySet() → clés UNIQUES
            for (String item : counts.keySet()) {
                int count = counts.get(item);
                out.println("<li>");
                out.println("<span>" + item + "</span>");
                out.println("<span class='badge'>" + count + "×</span>");
                out.println("</li>");
            }
            out.println("</ul>");
        }

        out.println("<a href='items.html'>➕ Ajouter un autre item</a><br>");
        out.println("<a href='index.html'>🏠 Retour à l'accueil</a>");
        out.println("</div></body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si on accède par GET, rediriger vers le formulaire
        response.sendRedirect("items.html");
    }
}