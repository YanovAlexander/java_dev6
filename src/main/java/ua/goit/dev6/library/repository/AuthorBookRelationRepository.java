package ua.goit.dev6.library.repository;

import org.apache.log4j.Logger;
import ua.goit.dev6.library.config.HibernateProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthorBookRelationRepository {
    private static final Logger LOG = Logger.getLogger(AuthorBookRelationRepository.class);

    private final HibernateProvider manager;

    private static final String INSERT = "INSERT INTO author_book_relation(author_id, book_id) VALUES(?,?)";
    private static final String SELECT_BY_ID = "SELECT author_id FROM author_book_relation WHERE book_id = ?";


    public AuthorBookRelationRepository(HibernateProvider manager) {
        this.manager = manager;
    }

    public void save(Set<Integer> authorIds, Integer bookId) {
//        StringBuilder insertSql = new StringBuilder();
//        insertSql.append("INSERT INTO author_book_relation(author_id, book_id) VALUES ");
//        for (int i : authorIds) {
//            insertSql.append("(?,?),");
//        }
//        insertSql.deleteCharAt(insertSql.length() - 1);
//        try (Connection connection = manager.getConnection();
//             PreparedStatement statement = connection.prepareStatement(insertSql.toString())) {
//            int index = 1;
//            for (int authorId : authorIds) {
//                statement.setInt(index++, authorId);
//                statement.setInt(index++, bookId);
//            }
//            statement.execute();
//        } catch (SQLException ex) {
//            LOG.error(String.format("Save authorBookRelation with bookId %s", bookId), ex);
//            throw new RuntimeException("Author not created");
//        }
    }

    public List<Integer> findByBookId(Integer id) {
//        try(Connection connection = manager.getConnection();
//            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            return retrieveIds(resultSet);
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//        return new ArrayList<>();
        return null;
    }

    private List<Integer> retrieveIds(ResultSet resultSet) throws SQLException {
        List<Integer> ids = new ArrayList<>();
        while (resultSet.next()) {
            ids.add(resultSet.getInt("author_id"));
        }
        return ids;
    }
}