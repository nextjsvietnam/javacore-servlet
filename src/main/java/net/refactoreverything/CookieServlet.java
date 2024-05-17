import dao.LoginDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="CookieServlet", urlPatterns = {"/login"}, initParams = {
        @WebInitParam(name="email", value = "techlead@javacore.net"),
        @WebInitParam(name="password", value="javacore.net@2024")
})
public class CookieServlet extends HttpServlet {

    private User doLogin(String email, String password) {
//        var config = getServletConfig();
//        String systemEmail = config.getInitParameter("email");
//        String systemPassword = config.getInitParameter("password");
//        if(systemEmail.equals(email) && systemPassword.equals(password)) {
//            return new User(1, email);
//        }
        LoginDao dao = new LoginDao();
        if(dao.check(email, password)){
            return new User(1, email);
        }
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var context = req.getServletContext();
        String redirectUrl = req.getParameter("redirectUrl");

        if(redirectUrl != null) {
            req.getSession().setAttribute("redirectUrl", redirectUrl);
        }
        context.getRequestDispatcher("/views/auth/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        ArrayList<String> errors = new ArrayList<String>();
        if(email == null || email.isEmpty()) {
            errors.add("Email is required!");
        }
        if(password == null || password.isEmpty()) {
            errors.add("Password is required!");
        }
        // do login
        User user = doLogin(email, password);
        if(user == null) {
            errors.add("Invalid email or password!");
        }
        if(!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            doGet(req, resp);
            return;
        }
        // otherwise, create cookie
        Cookie userCookie = new Cookie("user", user.convertToCookieValue());
        resp.addCookie(userCookie);
        // redirect to dashboard after login successful
        var redirectUrlSession = req.getSession().getAttribute("redirectUrl");
        String redirectUrl = redirectUrlSession != null ? redirectUrlSession.toString() : "/dashboard";
        String redirectPath = req.getContextPath() + redirectUrl;
        resp.sendRedirect(redirectPath);
    }
}
