package ex1;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


public class RequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("📥 [RequestListener] Nouvelle requête reçue (requestInitialized)");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("📤 [RequestListener] Requête terminée (requestDestroyed)");
    }
}