package ua.goit.dev6.library;

import java.time.Year;
import java.util.Scanner;

public class JournalService {
    private final Repository repository;
    public JournalService(Repository repository) {
        this.repository = repository;
    }

    public void addJournalToRepository(Scanner scanner) {
        System.out.println("enter journal name: ");
        String name = scanner.nextLine();

        int pageCount = getIntValue(scanner, "enter count of pages: ");
        int number = getIntValue(scanner, "enter journal number, please: ");
        int year = getIntValue(scanner, "enter year of publication, please: ");

        Journal journal = new Journal(name, pageCount, number, year);
        repository.add(journal);
        System.out.println("Journal successfully added");
    }

    private int getIntValue(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.println(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("invalid value. Use digits");
            }
        }
    }
}
