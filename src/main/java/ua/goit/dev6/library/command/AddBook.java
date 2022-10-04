package ua.goit.dev6.library.command;

import org.apache.log4j.Logger;
import ua.goit.dev6.library.exceptions.AuthorAlreadyExistException;
import ua.goit.dev6.library.model.dto.AuthorDto;
import ua.goit.dev6.library.model.dto.BookDto;
import ua.goit.dev6.library.service.BookService;
import ua.goit.dev6.library.view.View;

import java.util.HashSet;
import java.util.Set;

public class AddBook implements Command {
    public static final String ADD_BOOK = "add_book";
    private final View view;
    private final BookService bookService;
    private final static Logger LOG = Logger.getLogger(AddBook.class);

    public AddBook(View view, BookService bookService) {
        this.view = view;
        this.bookService = bookService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(ADD_BOOK);
    }

    @Override
    public void execute() {
        view.write("Enter book name: ");
        String name = view.read();
        int pageCount = -1;
        while (true) {
            try {
                view.write("Enter count of pages: ");
                pageCount = Integer.parseInt(view.read());
                break;
            } catch (NumberFormatException e) {
                LOG.warn("User provided wrong number", e);
                view.write("Invalid value. Use digits");
            }
        }
        while (true) {
            try {
                BookDto book = new BookDto(name, pageCount, createAuthor());
                bookService.save(book);
                break;
            } catch (AuthorAlreadyExistException exception) {
                LOG.warn("User provided already exists author", exception);
                view.write(exception.getMessage());
            }
        }
        view.write("Book added. Thank you!");
    }

    private Set<AuthorDto> createAuthor() {
        Set<AuthorDto> authors = new HashSet<>();
        while (true) {
            view.write("Enter author first name: ");
            String firstName = view.read();
            view.write("Enter author last name: ");
            String lastName = view.read();
            view.write("Enter author email: ");
            String email = view.read();
            authors.add(new AuthorDto(firstName, lastName, email));
            view.write("to add the next author, enter yes, or to exit, enter no");
            if (view.read().equals("no")) {
                break;
            }
        }
        return authors;
    }
}
