package ua.goit.dev6.library.repository;

import ua.goit.dev6.library.model.dao.AuthorDao;
import ua.goit.dev6.library.model.dao.BookDao;

import java.util.List;
import java.util.Set;

public interface Repository<T> {
    T save(T entity);
    void delete(T entity);
    T findById(int id);
    Set<AuthorDao> findAll();
    List<BookDao> findByName(String bookName);
    Set<AuthorDao> findByIds(List<Integer> authorIds);
    Set<AuthorDao> findByBookId(Integer bookId);
}