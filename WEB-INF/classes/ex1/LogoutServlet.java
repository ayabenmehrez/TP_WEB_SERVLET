package ex1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Récupérer la session (false = on ne la recrée pas si elle n'existe pas)
        HttpSession session = request.getSession(false);

        // 2. Invalider la session (c'est ça qui la détruit sur le serveur)
        if (session != null) {
            session.invalidate(); 
            System.out.println("[LogoutServlet] Session invalidée avec succès.");
        }

        // 3. Rediriger l'utilisateur vers la page de login
        response.sendRedirect("index.html");
    }
}