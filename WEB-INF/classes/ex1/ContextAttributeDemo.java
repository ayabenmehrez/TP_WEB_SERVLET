package ex1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextAttributeDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        ServletContext ctx = getServletContext();

        if ("add".equals(action)) {
            ctx.setAttribute("demoApp", "valeur initiale");
        } else if ("replace".equals(action)) {
            ctx.setAttribute("demoApp", "valeur modifiée");
        } else if ("remove".equals(action)) {
            ctx.removeAttribute("demoApp");
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html><html lang='fr'><head><meta charset='UTF-8'><title>Test AppAttribute</title>");
        out.println("<style>");
        out.println("body{font-family:'Segoe UI',sans-serif;background:#f5f7fb;display:flex;justify-content:center;align-items:center;min-height:100vh;margin:0;padding:1.5rem;}");
        out.println(".card{background:#fff;border-radius:24px;padding:2rem 3rem;box-shadow:0 20px 35px -8px rgba(0,20,30,0.2);text-align:center;max-width:550px;width:100%;}");
        out.println("h2{color:#0b2b3c;font-weight:500;}");
        out.println(".value-box{background:#e2eff8;color:#004466;padding:1rem;border-radius:12px;font-weight:bold;font-size:1.2rem;margin:1.5rem 0;}");
        out.println(".btn{display:inline-block;padding:0.8rem 1.5rem;margin:0.3rem;border-radius:40px;text-decoration:none;color:#fff;font-weight:600;transition:0.3s;}");
        out.println(".btn-add{background:#28a745;} .btn-add:hover{background:#218838;}");
        out.println(".btn-replace{background:#f39c12;} .btn-replace:hover{background:#e67e22;}");
        out.println(".btn-remove{background:#e74c3c;} .btn-remove:hover{background:#c0392b;}");
        out.println(".link{display:block;margin-top:1.5rem;color:#0077be;text-decoration:none;font-weight:600;}");
        out.println("</style></head><body>");
        
        out.println("<div class='card'>");
        out.println("<h2>🌐 Test ApplicationAttributeListener</h2>");
        out.println("<div class='value-box'>Valeur actuelle : " + ctx.getAttribute("demoApp") + "</div>");
        
        out.println("<a href='ContextAttributeDemo?action=add' class='btn btn-add'>➕ Ajouter</a>");
        out.println("<a href='ContextAttributeDemo?action=replace' class='btn btn-replace'>🔄 Remplacer</a>");
        out.println("<a href='ContextAttributeDemo?action=remove' class='btn btn-remove'>❌ Supprimer</a>");
        
        out.println("<a href='index.html' class='link'>🏠 Retour à l'accueil</a>");
        out.println("</div></body></html>");
    }
}