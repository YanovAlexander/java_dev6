package ua.goit.dev6.library.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.dev6.library.config.HibernateProvider;
import ua.goit.dev6.library.model.dao.AuthorDao;
import ua.goit.dev6.library.model.dao.BookDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BookRepository implements Repository<BookDao> {

    private final HibernateProvider manager;

    public BookRepository(HibernateProvider manager) {
        this.manager = manager;
    }

    @Override
    public BookDao save(BookDao entity) {
        try (Session session = manager.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
        return entity;
    }

    @Override
    public void delete(BookDao entity) {

    }

    @Override
    public BookDao findById(int id) {
        return null;
    }

    @Override
    public Set<AuthorDao> findAll() {
        return null;
    }

    public List<BookDao> findByBookName(String bookName) {
        try (final Session session = manager.openSession()) {
            final Transaction transaction = session.beginTransaction();
            return session.createQuery("FROM BookDao as book WHERE book.name like :name", BookDao.class)
                    .setParameter("name", "%" + bookName + "%")
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Set<AuthorDao> findByIds(List<Integer> authorIds) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public Set<AuthorDao> findByBookId(Integer bookId) {
        return null;
    }
}
