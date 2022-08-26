package ua.goit.dev6.library.repository;

import ua.goit.dev6.library.config.DatabaseManagerConnector;
import ua.goit.dev6.library.model.dao.BookDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookRepository implements Repository<BookDao>{

    private final DatabaseManagerConnector manager;

    private static final String INSERT = "INSERT INTO BOOK (name, count_pages, author_id) VALUES (?, ?, ?)";

    public BookRepository(DatabaseManagerConnector manager) {
        this.manager = manager;
    }

    @Override
    public BookDao save(BookDao entity) {
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)){
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getCountPages());
            statement.setInt(3, entity.getAuthor().getId());
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
    public List<BookDao> findAll() {
        return null;
    }
}
