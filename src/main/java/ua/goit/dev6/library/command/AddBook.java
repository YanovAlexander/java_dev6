package ua.goit.dev6.library.command;

import ua.goit.dev6.library.exceptions.AuthorAlreadyExistException;
import ua.goit.dev6.library.model.dto.AuthorDto;
import ua.goit.dev6.library.model.dto.BookDto;
import ua.goit.dev6.library.service.BookService;
import ua.goit.dev6.library.view.View;

public class AddBook implements Command {
    public static final String ADD_BOOK = "add_book";
    private final View view;
    private final BookService bookService;

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
                view.write("Invalid value. Use digits");
            }
        }
        while(true) {
            try {
                BookDto book = new BookDto(name, pageCount, createAuthor());
                bookService.save(book);
                break;
            } catch (AuthorAlreadyExistException exception) {
                view.write(exception.getMessage());
            }
        }
        view.write("Book added. Thank you!");
    }


    private AuthorDto createAuthor() {
        view.write("Enter author first name: ");
        String firstName = view.read();
        view.write("Enter author last name: ");
        String lastName = view.read();
        view.write("Enter author email: ");
        String email = view.read();
        return new AuthorDto(firstName, lastName, email);
    }
}
