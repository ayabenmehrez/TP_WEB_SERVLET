package ex1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
// L'annotation est commentée car on utilise web.xml
// import javax.servlet.annotation.WebFilter;

// @WebFilter("/*") 
public class LoggingFilter implements Filter {

    private String logPrefix = "[LoggingFilter]";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String prefixParam = filterConfig.getInitParameter("logPrefix");
        if (prefixParam != null) {
            this.logPrefix = prefixParam;
        }
        System.out.println("=================================================");
        System.out.println(logPrefix + " init() : FILTRE INITIALISÉ");
        System.out.println("=================================================");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url    = httpRequest.getRequestURL().toString();
        String uri    = httpRequest.getRequestURI();
        String method = httpRequest.getMethod();

        // ---- AVANT de passer au servlet ----
        System.out.println(logPrefix + " AVANT servlet → URL demandée : " + url);
        System.out.println(logPrefix + "   méthode = " + method + " | URI = " + uri);

        // 👇 MODIFICATION ICI : Utilisation de System.nanoTime()
        long startTime = System.nanoTime();

        // On laisse la requête continuer
        chain.doFilter(request, response);

        // 👇 MODIFICATION ICI : Calcul du temps en millisecondes
        long endTime = System.nanoTime();
        long durationNano = endTime - startTime;
        long durationMillis = durationNano / 1_000_000; // Conversion en ms

        // ---- APRÈS le traitement du servlet ----
        System.out.println(logPrefix + " APRÈS servlet → réponse renvoyée pour : " + uri 
                           + " (durée : " + durationMillis + " ms)");
    }

    @Override
    public void destroy() {
        System.out.println("=================================================");
        System.out.println(logPrefix + " destroy() : FILTRE DÉTRUIT");
        System.out.println("=================================================");
    }
}