package ua.goit.dev6.library;

public class Repository {
    private Publication[] publications;
    private static final int DEFAULT_ARRAY_SIZE = 16;

    public Repository() {
        this.publications = new Publication[DEFAULT_ARRAY_SIZE];
    }

    public Repository(int size) {
        this.publications = new Publication[size];
    }
}