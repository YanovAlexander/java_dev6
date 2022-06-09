package ua.goit.dev6.library.repository;

import ua.goit.dev6.library.model.Publication;

import java.util.Arrays;

public class InMemoryArrayRepository implements Repository {
    private Publication[] publications;
    private int cursor = 0;
    private static final int DEFAULT_ARRAY_SIZE = 16;

    public InMemoryArrayRepository() {
        this.publications = new Publication[DEFAULT_ARRAY_SIZE];
    }

    public InMemoryArrayRepository(int size) {
        this.publications = new Publication[size];
    }

    @Override
    public void add(Publication publication) {
        increaseArraySize();
        publications[cursor] = publication;
        cursor++;
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index <= cursor) {
            publications[index] = null;
        }

    }

    @Override
    public void delete(Publication publication) {
        for (int i = 0; i < publications.length; i++) {
            if (publications[i] != null && publications[i].equals(publication)) {
                publications[i] = null;
            }
        }
    }

    @Override
    public Publication find(int index) {
        if (cursor < index || index < 0) {
            return null;
        }
        return publications[index];
    }

    @Override
    public boolean contains(Publication publication) {
        for (Publication currentPublication : publications) {
            if (currentPublication != null && currentPublication.equals(publication)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Publication[] findAll() {
        return Arrays.copyOf(publications, publications.length);
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
