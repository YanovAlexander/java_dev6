package ua.goit.dev6.library;

public class Journal extends Publication {
    private int number;
    private int publicationYear;

    public Journal (String name, int countPages, int number, int publicationYear) {
        super(name, countPages);
        this.number = number;
        this.publicationYear = publicationYear;
    }

    @Override
    public String print() {
        return "Journal{" + super.print() + ", number= " + number + ", year= " + publicationYear + "}";
    }
}
