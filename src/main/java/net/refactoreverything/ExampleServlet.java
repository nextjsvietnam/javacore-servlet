import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import model.Example;
import model.Status;


@WebServlet(name = "ExampleServlet", urlPatterns = {"/examples", "/examples/*"})
public class ExampleServlet extends HttpServlet {

    private Status statusToEnum(Integer status){
        switch (status){
            case 0: return Status.Active;
            case 1: return Status.Inactive;
        }
        return Status.Unknown;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        Integer status = req.getParameter("status") != null ? Integer.parseInt(req.getParameter("status")) : null;
        var servletContext = getServletContext();
        if (title != null && status != null) {
            System.out.println(title + ":" + status);
            req.setAttribute("example", new Example(title, statusToEnum(status)));
            servletContext.getRequestDispatcher("/views/examples/search.jsp").forward(req, resp);
            return;
        }
        servletContext.getRequestDispatcher("/views/examples/index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        Integer status = req.getParameter("status") != null ? Integer.parseInt(req.getParameter("status")) : null;
        var errors = new ArrayList<String>();
        if(title == null || title.isEmpty()){
            errors.add("Title must not be null!");
        }
        if(status == null){
            errors.add("Status must not be null!");
        }
        if(title != null && status != null) {
            Example example = new Example(title, statusToEnum(status));
            req.setAttribute("example", example);
        } else {
            req.setAttribute("errors", errors);
        }
        doGet(req, resp);
    }
}
