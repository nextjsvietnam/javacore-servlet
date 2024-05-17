package filter;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/books")
public class LogFilter implements Filter {
    private User getLogggedInUser(HttpServletRequest req, HttpServletResponse resp){
        var cookies = req.getCookies();
        if(cookies != null){
            for(var cookie : cookies){
                if(cookie.getName().equals("user")){
                    return new User(Integer.parseInt(cookie.getValue()), "contact@javacore.net");
                }
            }
        }
        return null;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter:books");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        User user = getLogggedInUser(req, resp);
        String servletPath = req.getServletPath();
        if(user == null)
           resp.sendRedirect("/login?redirectUrl=" + servletPath);
        else
            chain.doFilter(request, response);
    }
}
