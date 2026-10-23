package ex1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ⚠️ PAS d'annotation @WebServlet
public class VisitCounter extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int visits = 0;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("visitCount".equals(c.getName())) {
                    try { visits = Integer.parseInt(c.getValue()); }
                    catch (NumberFormatException e) { visits = 0; }
                }
            }
        }

        visits++;

        Cookie newCookie = new Cookie("visitCount", String.valueOf(visits));
        newCookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(newCookie);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body style='font-family:sans-serif;text-align:center;"
                  + "padding:3rem;background:#f5f7fb;'>");
        out.println("<h1>👋 Nombre de visites : " + visits + "</h1>");
        out.println("<p><a href='VisitCounter'>🔄 Rafraîchir</a> | "
                  + "<a href='index.html'>🏠 Formulaire</a></p>");
        out.println("</body></html>");
    }
}