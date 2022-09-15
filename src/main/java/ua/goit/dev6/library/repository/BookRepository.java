package ua.goit.dev6.library.repository;

import ua.goit.dev6.library.config.DatabaseManagerConnector;
import ua.goit.dev6.library.model.dao.BookDao;

import java.sql.*;
import java.util.List;

public class BookRepository implements Repository<BookDao> {

    private final DatabaseManagerConnector manager;

    private static final String INSERT = "INSERT INTO BOOK (name, count_pages) VALUES (?, ?)";


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
    public List<BookDao> findAll() {
        return null;
    }
}
