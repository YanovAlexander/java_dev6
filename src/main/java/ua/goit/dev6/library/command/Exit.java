package ua.goit.dev6.library.command;

import ua.goit.dev6.library.exceptions.ExitException;
import ua.goit.dev6.library.view.View;

public class Exit implements Command {
    public static final String EXIT = "exit";
    public static final String BYE_MESSAGE = "Bye!";

    private final View view;

    public Exit(View view) {
        this.view = view;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(EXIT);
    }

    @Override
    public void execute() {
        view.write(BYE_MESSAGE);
        throw new ExitException();
    }
}
