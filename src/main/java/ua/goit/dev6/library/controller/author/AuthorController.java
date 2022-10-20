package ua.goit.dev6.library.controller.author;

import ua.goit.dev6.library.config.HibernateProvider;
import ua.goit.dev6.library.model.dto.AuthorDto;
import ua.goit.dev6.library.repository.AuthorRepository;
import ua.goit.dev6.library.service.AuthorService;
import ua.goit.dev6.library.service.converter.AuthorConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(urlPatterns = "/authors")
public class AuthorController extends HttpServlet {
    private AuthorService authorService;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        AuthorRepository authorRepository = new AuthorRepository(dbProvider);
        AuthorConverter authorConverter = new AuthorConverter();
        authorService = new AuthorService(authorRepository, authorConverter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authorName = req.getParameter("authorName");
        Set<AuthorDto> authors = authorService.findByName(authorName);
        req.setAttribute("authors", authors);
        //TODO send  to the correct page
        req.getRequestDispatcher("/WEB-INF/jsp/book/findBook.jsp").forward(req, resp);
    }
}
