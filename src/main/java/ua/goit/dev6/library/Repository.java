package ua.goit.dev6.library;

public class Repository {
    private Publication[] publications;
    private int cursor = 0;
    private static final int DEFAULT_ARRAY_SIZE = 16;

    public Repository() {
        this.publications = new Publication[DEFAULT_ARRAY_SIZE];
    }

    public Repository(int size) {
        this.publications = new Publication[size];
    }

    public void addPublication(Publication publication) {
        increaseArraySize();
        publications[cursor] = publication;
        cursor ++;
    }

    private void increaseArraySize() {
        if (cursor >= publications.length ) {
            Publication[] newPublications = new Publication[publications.length * 2];
            for (int i=0; i< publications.length; i++) {
                newPublications[i] = publications[i];
            }
            publications = newPublications;
        }
    }

}