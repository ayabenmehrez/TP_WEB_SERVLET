package ex1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ⚠️ PAS d'annotation @WebServlet
public class ReadCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        String firstName = "—", lastName = "—", birthDate = "—", sex = "—";

        if (cookies != null) {
            for (Cookie c : cookies) {
                String v = URLDecoder.decode(c.getValue(), "UTF-8");
                switch (c.getName()) {
                    case "firstName": firstName = v; break;
                    case "lastName":  lastName  = v; break;
                    case "birthDate": birthDate = v; break;
                    case "sex":       sex       = v; break;
                }
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='fr'><head><meta charset='UTF-8'>");
        out.println("<title>Lecture des cookies</title>");
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
        out.println("<h2>🍪 Cookies lus par le serveur</h2>");

        out.println("<table>");
        out.println("<tr><th>Cookie</th><th>Valeur</th></tr>");
        out.println("<tr><td>firstName</td><td>" + firstName + "</td></tr>");
        out.println("<tr><td>lastName</td><td>"  + lastName  + "</td></tr>");
        out.println("<tr><td>birthDate</td><td>" + birthDate + "</td></tr>");
        out.println("<tr><td>sex</td><td>"       + sex       + "</td></tr>");
        out.println("</table>");

        out.println("<div class='link'>");
        out.println("<a href='index.html'>⬅ Retour au formulaire</a>");
        out.println("</div>");

        out.println("</div></body></html>");
    }
}