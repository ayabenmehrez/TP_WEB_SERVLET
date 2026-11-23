package ex1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("[SecurityFilter] init()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest  httpReq  = (HttpServletRequest)  request;
        HttpServletResponse httpResp = (HttpServletResponse) response;

        // getSession(false) : NE CRÉE PAS de session si elle n'existe pas
        HttpSession session = httpReq.getSession(false);
        boolean connected = (session != null && session.getAttribute("user") != null);

        System.out.println("[SecurityFilter] AVANT → user connecté ? " + connected);

        if (connected) {
            chain.doFilter(request, response);
            System.out.println("[SecurityFilter] APRÈS → requête laissée passer");
        } else {
            System.out.println("[SecurityFilter] BLOQUÉ → redirection vers login.html");
            httpResp.sendRedirect(httpReq.getContextPath() + "/login.html");
            // ⚠️ On N'APPELLE PAS chain.doFilter() → le servlet ne s'exécute pas
        }
    }

    @Override
    public void destroy() {
        System.out.println("[SecurityFilter] destroy()");
    }
}