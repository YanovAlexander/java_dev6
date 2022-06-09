package ua.goit.dev6.library.command;

public interface Command {
    boolean canExecute(String input);

    void execute();
}
