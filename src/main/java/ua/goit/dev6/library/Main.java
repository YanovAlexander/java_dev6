package ua.goit.dev6.library;

import java.util.Scanner;

public class Main {
    private static final String HELP_COMMAND = "help";
    private static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, please enter help to see all command");
        while (true) {
            String command = scanner.nextLine();
            if (command.equals(HELP_COMMAND)) {
                System.out.println("Enter help to see all command");
                System.out.println("Enter exit to exit program");
            } else if (command.equals(EXIT_COMMAND)) {
                System.out.println("Good bye");
                return;
            } else {
                System.out.println("Command not found");
            }
        }

    }
}
