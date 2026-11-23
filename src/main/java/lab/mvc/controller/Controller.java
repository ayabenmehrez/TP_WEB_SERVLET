package lab.mvc.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.mvc.model.Person;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // L'énoncé demande de ne traiter que le POST (car les données viennent du formulaire)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Récupérer les paramètres du formulaire
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDay"); // ex: "12/05/1985"
        String sex = request.getParameter("sex");

        // 2. Créer l'objet Person (Le Modèle)
        Person person = new Person(firstName, lastName, birthDay, sex);

        // 3. Stocker l'objet dans la requête
        request.setAttribute("person", person);

        // 4. Logique pour choisir la bonne Vue (JSP)
        RequestDispatcher dispatcher;
        
        try {
            // On extrait l'année de naissance (supposons le format mm/dd/yyyy)
            String[] dateParts = birthDay.split("/");
            int year = Integer.parseInt(dateParts[2]);

            if (year < 1990) {
                // Né avant 1990
                dispatcher = getServletContext().getRequestDispatcher("/old.jsp");
            } else {
                // Né en 1990 ou après
                dispatcher = getServletContext().getRequestDispatcher("/young.jsp");
            }
        } catch (Exception e) {
            // En cas d'erreur de format de date, on redirige par défaut
            dispatcher = getServletContext().getRequestDispatcher("/young.jsp");
        }

        // 5. Transférer la requête à la page JSP
        dispatcher.forward(request, response);
    }
}