package ua.goit.dev6.library;

import java.util.Scanner;

public class Main {
    private static final String HELP_COMMAND = "help";
    private static final String EXIT_COMMAND = "exit";
    private static final String ADD_BOOK_COMMAND = "add book";
    private static final String ADD_JOURNAL_COMMAND = "add journal";

    public static void main(String[] args) {
        Repository repository = new Repository();
        BookService bookService = new BookService(repository);
        JournalService journalService = new JournalService(repository);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, please enter help to see all command");
        while (true) {
            String command = scanner.nextLine();
            if (command.equals(HELP_COMMAND)) {
                System.out.println("Enter help to see all command");
                System.out.println("Enter exit to exit program");
                System.out.println("Enter add book command to add book to the library");
                System.out.println("Enter add journal command to add journal to the library");
            } else if (command.equals(EXIT_COMMAND)) {
                System.out.println("Good bye");
                return;
            } else if (command.equals(ADD_BOOK_COMMAND)) {
                bookService.addBookToRepository(scanner);
            } else if (command.equals(ADD_JOURNAL_COMMAND)) {
                journalService.addJournalToRepository(scanner);
            }
            else {
                System.out.println("Command not found");
            }
        }
    }
}
