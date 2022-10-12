package ua.goit.dev6.library.repository;

import ua.goit.dev6.library.config.DatabaseManagerConnector;
import ua.goit.dev6.library.model.dao.AuthorDao;
import ua.goit.dev6.library.model.dao.BookDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BookRepository implements Repository<BookDao> {

    private final DatabaseManagerConnector manager;

    private static final String INSERT = "INSERT INTO BOOK (name, count_pages) VALUES (?, ?)";
    private static final String SELECT_BY_NAME = "SELECT id, name, count_pages FROM book WHERE name LIKE ?";


    public BookRepository(DatabaseManagerConnector manager) {
        this.manager = manager;
    }

    @Override
    public BookDao save(BookDao entity) {
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getCountPages());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating book failed, no ID obtained.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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

    @Override
    public List<BookDao> findByName(String bookName) {
        try(Connection connection = manager.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_NAME)) {
            statement.setString(1, "%" + bookName + "%");
            ResultSet resultSet = statement.executeQuery();
            return mapBookDaos(resultSet);
        } catch (SQLException exception) {
            exception.printStackTrace();
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
