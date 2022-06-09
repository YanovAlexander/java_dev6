package ua.goit.dev6.library.repository;

import ua.goit.dev6.library.model.Publication;

public interface Repository {
    void add(Publication publication);
    void delete(int index);
    void delete(Publication publication);
    Publication find(int index);
    boolean contains(Publication publication);
    Publication[] findAll();
}