package by.javaguru.je.jdbc.dao;

import by.javaguru.je.jdbc.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao implements Dao<Integer, User, Session> {

    private static final UserDao INSTANCE = new UserDao();


    private static final String GET_BY_EMAIL_AND_PASSWORD_SQL = "FROM User u WHERE u.email LIKE :email AND u.password LIKE :password";

    public static UserDao getInstance() {
        return INSTANCE;
    }

    @Override
    public User update(User user, Session session) {
        session.beginTransaction();
        session.merge(user);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public List<User> findAll(Session session) {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id, Session session) {
        User user = null;
        session.beginTransaction();
        user = session.get(User.class, id);
        session.getTransaction().commit();
        return Optional.ofNullable(user);
    }

    public Optional<User> findByEmailAndPassword(String email, String password, Session session) {
        User user = null;
        session.beginTransaction();
        Query<User> query = session.createQuery(GET_BY_EMAIL_AND_PASSWORD_SQL, User.class);
        query.setParameter("password", password);
        query.setParameter("email", email);
        user = query.uniqueResult();
        session.getTransaction().commit();
        return Optional.ofNullable(user);
    }

    @Override
    public User save(User user, Session session) {
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public void delete(Integer id, Session session) {
        session.beginTransaction();
        Optional.of(session.get(User.class, id)).ifPresent(session::remove);
        session.getTransaction().commit();
    }
}
