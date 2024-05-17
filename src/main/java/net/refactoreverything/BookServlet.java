import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.font.FontRenderContext;
import java.io.IOException;
import java.util.ArrayList;

import model.Book;

@WebServlet(name="BookServlet", urlPatterns = {"/books"})
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var servletContext = getServletContext();
        ArrayList<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setId(Integer.toString(i+1));
            book.setTitle("Book " + i);
            book.setAuthor("Author " + i);
            book.setPublisher("Publisher " + i);
            book.setDescription("Description " + i);
            books.add(book);
        }
        req.setAttribute("pageTitle", "Books");
        req.setAttribute("numberOfBooks", books.size());
        // resp.getWriter().print(books);
        servletContext.getRequestDispatcher("/views/books/index.jsp").forward(req, resp);
    }
}
