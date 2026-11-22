package ex1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        // Créer ou récupérer la session
        HttpSession session = request.getSession();
        
        // 👇 MODIFICATION ICI : On instancie l'objet SessionUser
        SessionUser sessionUser = new SessionUser(username);
        session.setAttribute("user", sessionUser); // 👈 On le met dans la session

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body style='font-family:sans-serif;text-align:center;padding:3rem;'>");
        out.println("<h1>Bienvenue, " + username + " 👋</h1>");
        out.println("<p>Session créée avec succès.</p>");
        out.println("<p><a href='items.html'>➡ Aller à la liste des items</a></p>");
        out.println("<p><a href='LogoutServlet'>🚪 Se déconnecter (test valueUnbound)</a></p>");
        out.println("</body></html>");
    }
}