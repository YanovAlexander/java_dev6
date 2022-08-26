package ua.goit.dev6.library;

import ua.goit.dev6.library.command.AddBook;
import ua.goit.dev6.library.command.Command;
import ua.goit.dev6.library.command.Exit;
import ua.goit.dev6.library.command.Help;
import ua.goit.dev6.library.config.DatabaseManagerConnector;
import ua.goit.dev6.library.config.PropertiesConfig;
import ua.goit.dev6.library.controller.Library;
import ua.goit.dev6.library.repository.InMemoryArrayRepository;
import ua.goit.dev6.library.repository.Repository;
import ua.goit.dev6.library.service.JournalService;
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

        DatabaseManagerConnector connector = new DatabaseManagerConnector(properties, dbUsername, dbPassword);
        connector.getConnection();
        Repository repository = new InMemoryArrayRepository();
        JournalService journalService = new JournalService(repository);
        Scanner scanner = new Scanner(System.in);
        View view = new Console(scanner);

        List<Command> commands = new ArrayList<>();
        commands.add(new Help(view));
        commands.add(new Exit(view));
        commands.add(new AddBook(view,repository));

        Library library = new Library(view, commands);

        library.run();
    }
}

