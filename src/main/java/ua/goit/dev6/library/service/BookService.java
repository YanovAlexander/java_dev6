package ua.goit.dev6.library.service;

import ua.goit.dev6.library.repository.Repository;
import ua.goit.dev6.library.model.Book;

import java.util.Scanner;

public class BookService {
    private final Repository repository;

    public BookService(Repository repository) {
        this.repository = repository;
    }

    public void addBookToRepository(Scanner scanner) {
        System.out.println("enter book name: ");
        String name = scanner.nextLine();
        int pageCount = -1;
        while (true) {
            try {
                System.out.println("enter count of pages: ");
                pageCount = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("invalid value. Use digits");
            }
        }
        System.out.println("enter author of the book: ");
        String author = scanner.nextLine();
        Book book = new Book(name, pageCount, author);
        repository.add(book);
        System.out.println("book added. Thank you!");
    }
}