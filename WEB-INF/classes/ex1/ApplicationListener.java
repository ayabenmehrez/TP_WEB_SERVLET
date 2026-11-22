package ex1;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("=================================================");
        System.out.println("🚀 [ApplicationListener] DÉMARRAGE DE L'APPLICATION");
        
        // Stocker un attribut dans le contexte de l'application
        ServletContext context = sce.getServletContext();
        context.setAttribute("appName", "ING1 Web Application");
        
        System.out.println("   Attribut 'appName' initialisé : " + context.getAttribute("appName"));
        System.out.println("=================================================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("=================================================");
        System.out.println("🛑 [ApplicationListener] ARRÊT DE L'APPLICATION");
        System.out.println("=================================================");
    }
}