package ex1;

import java.io.Serializable;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

// On implémente Serializable (utile pour l'étape 2 sur la passivation)
public class SessionUser implements HttpSessionBindingListener, Serializable {

    private String username;

    public SessionUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    // Appelée quand l'objet est ajouté dans la session
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("[SessionBinding] valueBound : L'utilisateur '" + username + "' a ete AJOUTE a la session " + event.getSession().getId());
    }

    // Appelée quand l'objet est retiré de la session (ou quand la session est invalidée)
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("[SessionBinding] valueUnbound : L'utilisateur '" + username + "' a ete RETIRE de la session " + event.getSession().getId());
    }
}