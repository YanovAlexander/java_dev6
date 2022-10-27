package ua.goit.dev6.library.repository;

import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.dev6.library.config.HibernateProvider;
import ua.goit.dev6.library.model.dao.AuthorDao;
import ua.goit.dev6.library.model.dao.BookDao;

import java.util.*;

public class AuthorRepository implements Repository<AuthorDao> {

    private final HibernateProvider manager;

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
        try (Session session = manager.openSession()) {
            Transaction transaction = session.beginTransaction();
            return new HashSet<>(session.createQuery("Select a From AuthorDao a", AuthorDao.class)
                    .getResultList());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new HashSet<>();
    }

    @Override
    public Set<AuthorDao> findByIds(List<Integer> authorIds) {
        try (Session session = manager.openSession()) {
            Transaction transaction = session.beginTransaction();

            MultiIdentifierLoadAccess<AuthorDao> multiLoadAccess = session.byMultipleIds(AuthorDao.class);
            return new HashSet<>(multiLoadAccess.multiLoad(authorIds));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HashSet<>();
    }

    public Set<AuthorDao> findByName(String authorName) {
        try (Session session = manager.openSession()){
            Transaction transaction = session.beginTransaction();
            return new HashSet<>(session.createQuery("FROM AuthorDao as a WHERE a.firstName like :name OR a.lastName like :name"
                            , AuthorDao.class)
                    .setParameter("name", "%" + authorName + "%")
                    .setCacheable(true)
                    .list());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HashSet<>();
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
}
