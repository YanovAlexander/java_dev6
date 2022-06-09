package ua.goit.dev6.library.command;

import ua.goit.dev6.library.model.Book;
import ua.goit.dev6.library.repository.Repository;
import ua.goit.dev6.library.view.View;

public class AddBook implements Command {
    public static final String ADD_BOOK = "add_book";
    private final View view;
    private final Repository repository;

    public AddBook(View view, Repository repository) {
        this.view = view;
        this.repository = repository;
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
        view.write("Enter author of the book: ");
        String author = view.read();
        Book book = new Book(name, pageCount, author);
        repository.add(book);
        view.write("Book added. Thank you!");
    }
}
