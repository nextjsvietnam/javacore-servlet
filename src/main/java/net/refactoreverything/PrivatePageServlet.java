import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="PrivatePageServlet", urlPatterns = {"/dashboard"})
public class PrivatePageServlet extends HttpServlet {
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var context = getServletContext();
        User user = getLogggedInUser(req,resp);
        if(user != null){
            context.getRequestDispatcher("/views/private.jsp").forward(req, resp);
            return;
        }
        // redirect user to login page
        resp.sendRedirect("/login");
    }
}
