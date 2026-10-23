package ex1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ⚠️ PAS d'annotation @WebServlet — déclaré dans web.xml
public class firstservlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName  = request.getParameter("lastName");
        String birthDate = request.getParameter("birthDate");
        String sex       = request.getParameter("sex");

        // Création des cookies avec encodage (obligatoire pour les espaces)
        Cookie cFirst = new Cookie("firstName", URLEncoder.encode(firstName, "UTF-8"));
        Cookie cLast  = new Cookie("lastName",  URLEncoder.encode(lastName,  "UTF-8"));
        Cookie cBirth = new Cookie("birthDate", URLEncoder.encode(birthDate, "UTF-8"));
        Cookie cSex   = new Cookie("sex",       URLEncoder.encode(sex,       "UTF-8"));

        cFirst.setMaxAge(60 * 60 * 24);
        cLast.setMaxAge(60 * 60 * 24);
        cBirth.setMaxAge(60 * 60 * 24);
        cSex.setMaxAge(60 * 60 * 24);

        response.addCookie(cFirst);
        response.addCookie(cLast);
        response.addCookie(cBirth);
        response.addCookie(cSex);

        // Affichage
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='fr'><head><meta charset='UTF-8'>");
        out.println("<title>Réponse du Servlet</title>");
        out.println("<style>");
        out.println("body{font-family:'Segoe UI',sans-serif;background:#f5f7fb;"
                  + "display:flex;justify-content:center;align-items:center;"
                  + "min-height:100vh;margin:0;padding:1.5rem;}");
        out.println(".card{background:#fff;border-radius:24px;padding:2rem;"
                  + "box-shadow:0 20px 35px -8px rgba(0,20,30,0.2);"
                  + "width:100%;max-width:600px;}");
        out.println("h2{color:#0b2b3c;font-weight:500;margin-top:0;}");
        out.println("table{width:100%;border-collapse:collapse;border-radius:14px;"
                  + "overflow:hidden;box-shadow:0 6px 18px rgba(0,0,0,0.05);}");
        out.println("th{background:#e2eff8;color:#004466;padding:0.9rem 1.2rem;"
                  + "text-align:left;text-transform:uppercase;"
                  + "border-bottom:2px solid #b8d2e4;}");
        out.println("td{padding:0.9rem 1.2rem;background:#fff;"
                  + "border-bottom:1px solid #dae8f2;color:#153e52;}");
        out.println(".link{margin-top:1.5rem;text-align:center;}");
        out.println(".link a{color:#0077be;font-weight:600;text-decoration:none;}");
        out.println("</style></head><body>");
        out.println("<div class='card'>");
        out.println("<h2>📬 Informations reçues</h2>");

        out.println("<table>");
        out.println("<tr><th>Champ</th><th>Valeur</th></tr>");
        out.println("<tr><td>Prénom</td><td>"            + firstName + "</td></tr>");
        out.println("<tr><td>Nom</td><td>"               + lastName  + "</td></tr>");
        out.println("<tr><td>Date de naissance</td><td>" + birthDate + "</td></tr>");
        out.println("<tr><td>Sexe</td><td>"              + sex       + "</td></tr>");
        out.println("</table>");

        out.println("<div class='link'>");
        out.println("<a href='ReadCookie'>👉 Voir mes cookies</a>");
        out.println("</div>");

        out.println("</div></body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}