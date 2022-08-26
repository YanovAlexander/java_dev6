package ua.goit.dev6.library.repository;

import ua.goit.dev6.library.config.DatabaseManagerConnector;
import ua.goit.dev6.library.model.dao.AuthorDao;

import java.sql.*;
import java.util.List;

public class AuthorRepository implements Repository<AuthorDao>{

    private final DatabaseManagerConnector manager;
    private static final String INSERT = "INSERT INTO author(first_name, last_name, email) VALUES(?,?,?)";

    public AuthorRepository(DatabaseManagerConnector manager) {
        this.manager = manager;
    }

    @Override
    public AuthorDao save(AuthorDao entity) {
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getEmail());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating author failed, no ID obtained.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Author not created");
        }
        return entity;
    }

    @Override
    public void delete(AuthorDao entity) {

    }

    @Override
    public AuthorDao findById(int id) {
        return null;
    }

    @Override
    public List<AuthorDao> findAll() {
        return null;
    }
}
