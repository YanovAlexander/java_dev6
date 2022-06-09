package ua.goit.dev6.library.repository;

import ua.goit.dev6.library.model.Publication;

public class InMemoryListRepository implements Repository {
    @Override
    public void add(Publication publication) {

    }

    @Override
    public void delete(int index) {

    }

    @Override
    public void delete(Publication publication) {

    }

    @Override
    public Publication find(int index) {
        return null;
    }

    @Override
    public boolean contains(Publication publication) {
        return false;
    }

    @Override
    public Publication[] findAll() {
        return new Publication[0];
    }
}
