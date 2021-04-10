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
        Admin a = (Admin) req.getSession().getAttribute("valid_user");
        String url = req.getRequestURI();
        if(a == null) {
            if(url.contains("home") || url.contains("logout")){
                res.sendRedirect(req.getContextPath()+"/adminLogin.xhtml");
            }else {
                chain.doFilter(request, response);
            }
        }else {
            if(url.contains("register") || url.contains("adminLogin")) {
                res.sendRedirect(req.getContextPath()+"/adminLogin.xhtml");
            }else if (url.contains("logout")){
                req.getSession().invalidate();
                res.sendRedirect(req.getContextPath()+"/index.xhtml");
            }else {
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
