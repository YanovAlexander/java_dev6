package ua.goit.dev6.library.command;

import ua.goit.dev6.library.view.View;

public class Help implements Command {
    private static final String HELP = "help";
    private final View view;

    public Help(View view) {
        this.view = view;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(HELP);
    }

    @Override
    public void execute() {
        view.write("Enter help to see all command");
        view.write("Enter exit to exit program");
        view.write("Enter add book command to add book to the library");
        view.write("Enter add journal command to add journal to the library");
    }
}
