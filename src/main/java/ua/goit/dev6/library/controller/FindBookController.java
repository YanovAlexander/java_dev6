package ua.goit.dev6.library.controller;

import ua.goit.dev6.library.config.DatabaseManagerConnector;
import ua.goit.dev6.library.config.PropertiesConfig;
import ua.goit.dev6.library.model.dto.BookDto;
import ua.goit.dev6.library.repository.AuthorBookRelationRepository;
import ua.goit.dev6.library.repository.AuthorRepository;
import ua.goit.dev6.library.repository.BookRepository;
import ua.goit.dev6.library.service.AuthorService;
import ua.goit.dev6.library.service.BookService;
import ua.goit.dev6.library.service.converter.AuthorConverter;
import ua.goit.dev6.library.service.converter.BookConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@WebServlet(urlPatterns = "/books")
public class FindBookController extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        String dbPassword = System.getenv("dbPassword");
        String dbUsername = System.getenv("dbusername");
        PropertiesConfig propertiesConfig = new PropertiesConfig();
        Properties properties = propertiesConfig.loadProperties("application.properties");
        DatabaseManagerConnector connector = new DatabaseManagerConnector(properties, dbUsername, dbPassword);
        AuthorRepository authorRepository = new AuthorRepository(connector);
        AuthorConverter authorConverter = new AuthorConverter();
        AuthorService authorService = new AuthorService(authorRepository, authorConverter);
        BookRepository bookRepository = new BookRepository(connector);
        AuthorBookRelationRepository authorBookRelationRepository = new AuthorBookRelationRepository(connector);
        BookConverter bookConverter = new BookConverter(authorConverter);
        bookService = new BookService(authorService, bookRepository, bookConverter, authorBookRelationRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter("bookName");
        List<BookDto> books = bookService.findByName(bookName);
        req.setAttribute("books", books);
        req.getRequestDispatcher("/jsp/findBook.jsp").forward(req, resp);
    }
}
