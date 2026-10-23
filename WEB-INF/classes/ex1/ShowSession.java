package ex1;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // Lire les attributs de session
        String  fullName    = (String)  session.getAttribute("fullName");
        String  birthDate   = (String)  session.getAttribute("birthDate");
        Integer visitCount  = (Integer) session.getAttribute("visitCount");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html><html lang='fr'><head><meta charset='UTF-8'>");
        out.println("<title>ShowSession</title>");
        out.println("<style>");
        out.println("body{font-family:'Segoe UI',sans-serif;background:#f5f7fb;"
                  + "display:flex;justify-content:center;align-items:center;"
                  + "min-height:100vh;margin:0;padding:1.5rem;}");
        out.println(".card{background:#fff;border-radius:24px;padding:2rem 3rem;"
                  + "box-shadow:0 20px 35px -8px rgba(0,20,30,0.2);"
                  + "text-align:center;max-width:550px;}");
        out.println("h1{color:#0b2b3c;font-weight:500;}");
        out.println("label{display:block;font-weight:600;font-size:0.85rem;"
                  + "color:#1a4b60;text-transform:uppercase;margin:1rem 0 0.4rem;"
                  + "text-align:left;}");
        out.println("input{width:100%;padding:0.8rem 1rem;border:1.5px solid #cbdae3;"
                  + "border-radius:12px;font-size:1rem;box-sizing:border-box;}");
        out.println("input:focus{outline:none;border-color:#0077be;"
                  + "box-shadow:0 0 0 4px rgba(0,119,190,0.15);}");
        out.println("button{background:#0077be;color:#fff;border:none;"
                  + "padding:0.9rem 2rem;font-size:1rem;font-weight:600;"
                  + "border-radius:40px;cursor:pointer;margin-top:1.5rem;width:100%;}");
        out.println("button:hover{background:#005f99;}");
        out.println(".count{color:#6d8b9c;font-size:0.9rem;margin-top:1rem;}");
        out.println("a{color:#0077be;font-weight:600;text-decoration:none;}");
        out.println("</style></head><body>");
        out.println("<div class='card'>");

        if (fullName == null || birthDate == null) {
            // ─── PREMIÈRE VISITE : afficher le formulaire ───
            visitCount = 1;
            session.setAttribute("visitCount", visitCount);

            out.println("<h1>Welcome on my site 👋</h1>");
            out.println("<p>C'est votre première visite. Dites-nous en plus :</p>");
            out.println("<form action='ShowSession' method='post'>");

            out.println("<label for='fullName'>Nom complet</label>");
            out.println("<input type='text' id='fullName' name='fullName' "
                      + "placeholder='ex. Emma Johnson' required>");

            out.println("<label for='birthDate'>Date de naissance (mm/dd/yyyy)</label>");
            out.println("<input type='text' id='birthDate' name='birthDate' "
                      + "placeholder='mm/dd/yyyy' "
                      + "pattern='(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}' "
                      + "title='Format attendu : mm/dd/yyyy' required>");

            out.println("<button type='submit'>Valider</button>");
            out.println("</form>");

        } else {
            // ─── VISITEUR DE RETOUR : afficher le message ───
            visitCount++;
            session.setAttribute("visitCount", visitCount);

            int days = joursAvantAnniversaire(birthDate);

            out.println("<h1>Welcome back 👋</h1>");
            out.println("<p style='font-size:1.2rem;color:#0b2b3c;margin-top:1.5rem;'>");
            out.println("Hi, <strong>" + fullName + "</strong>. ");
            out.println("There are <strong>" + days + "</strong> days to your birthday. 🎂");
            out.println("</p>");
            out.println("<p class='count'>Nombre de visites : " + visitCount + "</p>");
            out.println("<p><a href='ShowSession'>🔄 Rafraîchir</a></p>");
        }

        out.println("</div></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Récupérer les valeurs du formulaire
        String fullName  = request.getParameter("fullName");
        String birthDate = request.getParameter("birthDate");

        // Les stocker en session
        HttpSession session = request.getSession();
        session.setAttribute("fullName",  fullName);
        session.setAttribute("birthDate", birthDate);

        // Rediriger vers doGet pour afficher le message (pattern POST-Redirect-GET)
        response.sendRedirect("ShowSession");
    }

    /**
     * Calcule le nombre de jours entre aujourd'hui et le prochain anniversaire.
     * birthDateStr est au format mm/dd/yyyy
     */
    private int joursAvantAnniversaire(String birthDateStr) {
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate birth = LocalDate.parse(birthDateStr, fmt);

            LocalDate today = LocalDate.now();
            LocalDate nextBirthday = birth.withYear(today.getYear());

            // Si l'anniversaire est déjà passé cette année → prendre l'année prochaine
            if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
                nextBirthday = nextBirthday.plusYears(1);
            }

            return (int) ChronoUnit.DAYS.between(today, nextBirthday);

        } catch (Exception e) {
            return -1;  // date invalide
        }
    }
}