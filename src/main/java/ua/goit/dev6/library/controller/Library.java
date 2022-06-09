package ua.goit.dev6.library.controller;

import ua.goit.dev6.library.command.Command;
import ua.goit.dev6.library.exceptions.ExitException;
import ua.goit.dev6.library.view.View;

import java.util.List;

public class Library {
    private final View view;
    private final List<Command> commands;

    public Library(View view, List<Command> commands) {
        this.view = view;
        this.commands = commands;
    }


    public void run() {
        view.write("Hello, please enter help to see all command");
        try {
            execute();
        } catch (ExitException e) {}
    }

    private void execute() {
        while (true) {
            String input = view.read();
            boolean isInputCorrect = false;
            for (Command command : commands) {
                if (command.canExecute(input)) {

                    command.execute();
                    isInputCorrect = true;
                }
            }
            if (!isInputCorrect) {
                view.write("Command not found. Please enter help to see all commands");
            }
        }
    }


//    System.out.println("Hello, please enter help to see all command");
//        while (true) {
//        String command = scanner.nextLine();
//        else if (command.equals(EXIT_COMMAND)) {
//            System.out.println("Good bye");
//            return;
//        } else if (command.equals(ADD_BOOK_COMMAND)) {
//            bookService.addBookToRepository(scanner);
//        } else if (command.equals(ADD_JOURNAL_COMMAND)) {
//            journalService.addJournalToRepository(scanner);
//        }
}
