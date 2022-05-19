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

    public void add(Publication publication) {
        increaseArraySize();
        publications[cursor] = publication;
        cursor++;
    }

    public void delete(int index) {
        if (index >= 0 && index <= cursor) {
            publications[index] = null;
        }

    }

    public void delete(Publication publication) {
        for (int i = 0; i < publications.length; i++) {
            if (publications[i] != null && publications[i].equals(publication)) {
                publications[i] = null;
            }
        }
    }

    public Publication find(int index) {
        if (cursor < index || index < 0) {
            return null;
        }
        return publications[index];
    }

    public boolean contains(Publication publication) {
        for (Publication currentPublication : publications) {
            if (currentPublication != null && currentPublication.equals(publication)) {
                return true;
            }
        }
        return false;
    }

    public void printAll() {
        for (Publication publication : publications) {
            if (publication != null) {
                System.out.println(publication.print());
            }

        }
    }

    private void increaseArraySize() {
        if (cursor >= publications.length) {
            Publication[] newPublications = new Publication[publications.length * 2];
            for (int i = 0; i < publications.length; i++) {
                newPublications[i] = publications[i];
            }
            publications = newPublications;
        }
    }

}