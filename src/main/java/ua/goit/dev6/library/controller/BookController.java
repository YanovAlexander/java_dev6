package ua.goit.dev6.library.controller;

import ua.goit.dev6.library.config.DatabaseManagerConnector;
import ua.goit.dev6.library.config.PropertiesConfig;
import ua.goit.dev6.library.model.dto.AuthorDto;
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
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/books")
public class BookController extends HttpServlet {
    private BookService bookService;
    private AuthorService authorService;

    @Override
    public void init() throws ServletException {
        String dbPassword = System.getenv("dbPassword");
        String dbUsername = System.getenv("dbUsername");
        PropertiesConfig propertiesConfig = new PropertiesConfig();
        Properties properties = propertiesConfig.loadProperties("application.properties");
        DatabaseManagerConnector connector = new DatabaseManagerConnector(properties, dbUsername, dbPassword);
        AuthorRepository authorRepository = new AuthorRepository(connector);
        AuthorConverter authorConverter = new AuthorConverter();
        authorService = new AuthorService(authorRepository, authorConverter);
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
        req.getRequestDispatcher("/WEB-INF/jsp/findBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter("bookName");
        Integer countPages = Integer.parseInt(req.getParameter("countPages"));
        String[] authorIds = req.getParameterValues("authorId");
        List<Integer> authors = Arrays.stream(authorIds)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Set<AuthorDto> savedAuthors = authorService.findByIds(authors);
        BookDto bookDto = new BookDto(bookName, countPages, savedAuthors);
        bookService.save(bookDto);
        req.getRequestDispatcher("/WEB-INF/jsp/savedBook.jsp").forward(req, resp);
    }
}