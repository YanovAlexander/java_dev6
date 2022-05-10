package ua.goit.dev6.library;

public class Main {
    public static void main(String[] args) {
        Publication publication = new Publication("Book",60);
        System.out.println(publication.print());
        Book book = new Book("Book", 127, "anonim");
        System.out.println(book.print());
    }

}
