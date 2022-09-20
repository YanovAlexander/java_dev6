package ua.goit.dev6.library.repository;

import ua.goit.dev6.library.config.DatabaseManagerConnector;
import ua.goit.dev6.library.model.dao.AuthorDao;

import java.sql.*;
import java.util.Set;

public class AuthorBookRelationRepository {

    private final DatabaseManagerConnector manager;
    private static final String INSERT = "INSERT INTO author_book_relation(author_id, book_id) VALUES(?,?)";


    public AuthorBookRelationRepository(DatabaseManagerConnector manager) {
        this.manager = manager;
    }

    public void save(Set<Integer> authorIds, Integer bookId) {
        StringBuilder insertSql = new StringBuilder();
        insertSql.append("INSERT INTO author_book_relation(author_id, book_id) VALUES ");
        for (int i : authorIds) {
            insertSql.append("(?,?),");
        }
        insertSql.deleteCharAt(insertSql.length() - 1);
        try (Connection connection = manager.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertSql.toString())) {
            int index = 1;
            for (int authorId : authorIds) {
                statement.setInt(index++, authorId);
                statement.setInt(index++, bookId);
            }
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Author not created");
        }
    }

}