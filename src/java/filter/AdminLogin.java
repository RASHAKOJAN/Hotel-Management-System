package filter;

import entity.Admin;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class AdminLogin implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Cache-Control", "no-cache, max-age=0, must-revalidate,no-store");
        res.setHeader("X-UA-Compatible", "IE=edge");
        Admin a = (Admin) req.getSession().getAttribute("valid_user");
        String url = req.getRequestURI();
        String loginURL = req.getContextPath() + "/faces/adminLogin.xhtml";
        // boolean resourceRequest = req.getRequestURI().startsWith(req.getContextPath() + "/faces" + ResourceHandler.RESOURCE_IDENTIFIER);
        if (a == null) {
            if (url.contains("home") || url.contains("logout")) {
                res.sendRedirect(loginURL);
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (url.contains("register") || url.contains("adminLogin")) {
                res.sendRedirect(loginURL);
            } else if (url.contains("logout")) {
                req.getSession().invalidate();
                res.sendRedirect(req.getContextPath() + "/index.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
