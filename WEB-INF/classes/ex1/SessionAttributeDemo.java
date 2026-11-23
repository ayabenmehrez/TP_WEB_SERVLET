package ex1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionAttributeDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        if ("add".equals(action)) {
            session.setAttribute("user", "youta");
        } else if ("replace".equals(action)) {
            session.setAttribute("user", "youta_updated");
        } else if ("remove".equals(action)) {
            session.removeAttribute("user");
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html lang='fr'><head><meta charset='UTF-8'><title>Test Session</title></head><body style='font-family:sans-serif;text-align:center;padding:3rem;'>");
        out.println("<h2>🧪 Test SessionAttributeListener</h2>");
        out.println("<p>Valeur actuelle de 'user' : <strong>" + session.getAttribute("user") + "</strong></p>");
        out.println("<p><a href='SessionAttributeDemo?action=add'>➕ Ajouter 'user'</a> | "
                  + "<a href='SessionAttributeDemo?action=replace'>🔄 Modifier 'user'</a> | "
                  + "<a href='SessionAttributeDemo?action=remove'>❌ Supprimer 'user'</a></p>");
        out.println("<p><a href='index.html'>🏠 Retour</a></p>");
        out.println("</body></html>");
    }
}