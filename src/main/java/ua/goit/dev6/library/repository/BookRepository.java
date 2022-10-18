package ua.goit.dev6.library.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.dev6.library.config.HibernateProvider;
import ua.goit.dev6.library.model.dao.AuthorDao;
import ua.goit.dev6.library.model.dao.BookDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BookRepository implements Repository<BookDao> {

    private final HibernateProvider manager;

    private static final String INSERT = "INSERT INTO BOOK (name, count_pages) VALUES (?, ?)";
    private static final String SELECT_BY_NAME = "SELECT id, name, count_pages FROM book WHERE name LIKE ?";


    public BookRepository(HibernateProvider manager) {
        this.manager = manager;
    }

    @Override
    public BookDao save(BookDao entity) {
//        try (Connection connection = manager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
//            statement.setString(1, entity.getName());
//            statement.setInt(2, entity.getCountPages());
//            statement.executeUpdate();
//            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    entity.setId(generatedKeys.getInt(1));
//                } else {
//                    throw new SQLException("Creating book failed, no ID obtained.");
//                }
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return entity;
        return null;
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

    @Override
    public List<BookDao> findByName(String bookName) {
        try(final Session session = manager.openSession()) {
            final Transaction transaction = session.beginTransaction();
            return session.createQuery("FROM BookDao as book WHERE book.name like :name")
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

    private List<BookDao> mapBookDaos(ResultSet resultSet) throws SQLException {
        List<BookDao> books = new ArrayList<>();
        while (resultSet.next()) {
            BookDao dao = new BookDao();
            dao.setId(resultSet.getInt("id"));
            dao.setName(resultSet.getString("name"));
            dao.setCountPages(resultSet.getInt("count_pages"));
            books.add(dao);
        }
        return books;
    }
}
