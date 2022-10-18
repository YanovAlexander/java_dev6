package ua.goit.dev6.library.repository;

import ua.goit.dev6.library.config.HibernateProvider;
import ua.goit.dev6.library.model.dao.AuthorDao;
import ua.goit.dev6.library.model.dao.BookDao;

import java.sql.*;
import java.util.*;

public class AuthorRepository implements Repository<AuthorDao> {

    private final HibernateProvider manager;
    private static final String INSERT = "INSERT INTO author(first_name, last_name, email) VALUES(?,?,?)";
    private static final String SELECT_BY_EMAIL = "SELECT id, first_name, last_name, email " +
            "FROM AUTHOR WHERE email like ?";
    private static final String SELECT_BY_BOOK_ID = "SELECT a.id, a.first_name, a.last_name, a.email FROM author a " +
            "INNER JOIN author_book_relation abr ON a.id = abr.author_id " +
            "WHERE abr.book_id=?";
    private static final String SELECT_ALL = "SELECT a.id, a.first_name, a.last_name, a.email FROM author a";

    public AuthorRepository(HibernateProvider manager) {
        this.manager = manager;
    }

    @Override
    public AuthorDao save(AuthorDao entity) {
//        try (Connection connection = manager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
//            statement.setString(1, entity.getFirstName());
//            statement.setString(2, entity.getLastName());
//            statement.setString(3, entity.getEmail());
//            statement.executeUpdate();
//            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    entity.setId(generatedKeys.getInt(1));
//                } else {
//                    throw new SQLException("Creating author failed, no ID obtained.");
//                }
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            throw new RuntimeException("Author not created");
//        }
//        return entity;
        return null;
    }

    @Override
    public void delete(AuthorDao entity) {

    }

    @Override
    public AuthorDao findById(int id) {
        return null;
    }

    @Override
    public Set<AuthorDao> findAll() {
//        try (Connection connection = manager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
//            ResultSet resultSet = statement.executeQuery();
//             return mapAuthorDaos(resultSet);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return new HashSet<>();
        return null;
    }

    @Override
    public List<BookDao> findByName(String bookName) {
        return null;
    }

    @Override
    public Set<AuthorDao> findByIds(List<Integer> authorIds) {
//        String selectByIds = String.format("SELECT id, first_name, last_name, email FROM author WHERE id IN(%s)",
//                authorIds.stream()
//                        .map(v -> "?")
//                        .collect(Collectors.joining(", ")));
//
//        try (Connection connection = manager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(selectByIds)) {
//            int index = 1;
//            for (Integer authorId : authorIds) {
//                statement.setInt(index, authorId);
//                index++;
//            }
//            ResultSet resultSet = statement.executeQuery();
//            return mapAuthorDaos(resultSet);
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//        return new HashSet<>();
        return null;
    }

    @Override
    public Set<AuthorDao> findByBookId(Integer bookId) {
//        try (Connection connection = manager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(SELECT_BY_BOOK_ID)) {
//            statement.setInt(1, bookId);
//            ResultSet resultSet = statement.executeQuery();
//            return mapAuthorDaos(resultSet);
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//        return new HashSet<>();
        return null;
    }

    public Optional<AuthorDao> findByEmail(String email) {
//        try (Connection connection = manager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(SELECT_BY_EMAIL)) {
//            statement.setString(1, "%" + email + "%");
//            ResultSet resultSet = statement.executeQuery();
//            AuthorDao authorDao = mapAuthorDao(resultSet);
//            return Optional.ofNullable(authorDao);
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//        return Optional.empty();
        return null;
    }

    private AuthorDao mapAuthorDao(ResultSet resultSet) throws SQLException {
        AuthorDao author = null;
        while (resultSet.next()) {
            author = mapAuthor(resultSet);
        }
        return author;
    }

    private Set<AuthorDao> mapAuthorDaos(ResultSet resultSet) throws SQLException {
        Set<AuthorDao> authors = new HashSet<>();
        while (resultSet.next()) {
            authors.add(mapAuthor(resultSet));
        }
        return authors;
    }

    private AuthorDao mapAuthor(ResultSet resultSet) throws SQLException {
        AuthorDao author = new AuthorDao();
        author.setId(resultSet.getInt("id"));
        author.setFirstName(resultSet.getString("first_name"));
        author.setLastName(resultSet.getString("last_name"));
        author.setEmail(resultSet.getString("email"));
        return author;
    }
}
