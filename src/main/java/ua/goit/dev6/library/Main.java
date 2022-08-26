package ua.goit.dev6.library;

import ua.goit.dev6.library.command.AddBook;
import ua.goit.dev6.library.command.Command;
import ua.goit.dev6.library.command.Exit;
import ua.goit.dev6.library.command.Help;
import ua.goit.dev6.library.config.DatabaseManagerConnector;
import ua.goit.dev6.library.config.PropertiesConfig;
import ua.goit.dev6.library.controller.Library;
import ua.goit.dev6.library.repository.AuthorRepository;
import ua.goit.dev6.library.repository.BookRepository;
import ua.goit.dev6.library.service.AuthorService;
import ua.goit.dev6.library.service.BookService;
import ua.goit.dev6.library.service.converter.AuthorConverter;
import ua.goit.dev6.library.service.converter.BookConverter;
import ua.goit.dev6.library.view.Console;
import ua.goit.dev6.library.view.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        String dbPassword = System.getenv("dbPassword");
        String dbUsername = System.getenv("dbusername");
        PropertiesConfig propertiesConfig = new PropertiesConfig();
        Properties properties = propertiesConfig.loadProperties("application.properties");

        DatabaseManagerConnector manager = new DatabaseManagerConnector(properties, dbUsername, dbPassword);
        Scanner scanner = new Scanner(System.in);
        View view = new Console(scanner);

        AuthorRepository authorRepository = new AuthorRepository(manager);
        AuthorConverter authorConverter = new AuthorConverter();
        AuthorService authorService = new AuthorService(authorRepository, authorConverter);
        BookRepository bookRepository = new BookRepository(manager);
        BookConverter bookConverter = new BookConverter(authorConverter);
        BookService bookService = new BookService(authorService, bookRepository, bookConverter);

        List<Command> commands = new ArrayList<>();
        commands.add(new Help(view));
        commands.add(new Exit(view));
        commands.add(new AddBook(view, bookService));

        Library library = new Library(view, commands);

        library.run();
    }
}

