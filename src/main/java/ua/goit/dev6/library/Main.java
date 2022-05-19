package ua.goit.dev6.library;

public class Main {
    public static void main(String[] args) {
//        Publication publication = new Publication("Book",60);
//        System.out.println(publication.print());
//        Book book = new Book("Book", 127, "anonim");
//        System.out.println(book.print());
//        Journal journal = new Journal("Journal", 55, 7, 2022);
//        System.out.println(journal.print());
        Library library = new Library();
        library.printPublications(null);
        library.printPublications(new Publication[0]);
        library.printPublications(new Publication[]{new Journal("PC", 100, 1, 2021)});
        library.printPublications(new Publication[]{new Book("Witcher", 200, "Andrzej Sapkowski")});
        library.printPublications(new Publication[]{new Book("Master & Margarita", 300, "Mikhail Bulgakov"),
                new Journal("Gamer", 101, 10, 2018)});
    }

}
