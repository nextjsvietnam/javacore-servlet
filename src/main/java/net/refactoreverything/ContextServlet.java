import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContextServlet", urlPatterns = {"/token"}, initParams = {@WebInitParam(name = "privateKey", value = "jsp.javacore.net")})
public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authorizationToken = getServletContext().getInitParameter("authorizationToken");
        String privateKey = getServletConfig().getInitParameter("privateKey");
        System.out.println(authorizationToken);
        System.out.println(privateKey);
    }
}
