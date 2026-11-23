package ex1;

import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ActiveSessionListener implements HttpSessionListener {

    private static final AtomicInteger activeSessions = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        int current = activeSessions.incrementAndGet();
        System.out.println("➕ [ActiveSessionListener] Session créée. Actives : " + current);
        
        ServletContext context = se.getSession().getServletContext();
        context.setAttribute("activeSessions", current);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        int current = activeSessions.decrementAndGet();
        System.out.println("➖ [ActiveSessionListener] Session détruite. Actives : " + current);
        
        ServletContext context = se.getSession().getServletContext();
        context.setAttribute("activeSessions", current);
    }
}