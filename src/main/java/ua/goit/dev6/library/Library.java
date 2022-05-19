package ua.goit.dev6.library;

public class Library {

    public void printPublications(Publication[] publications) {
        if (publications == null || publications.length == 0) {
            System.out.println("There is no publications");
            return;
        }

        for (Publication publication : publications) {
            System.out.println(publication.print());
        }
    }
}