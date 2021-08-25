package dao;

import models.Auto;
import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.*;

public class UserDao implements Closeable {

    private final Session session;

    public UserDao() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    }

    @Override
    public void close() {
        session.close();
    }

    private <T> void sessionDoWithTransaction(T item, BiConsumer<Session, T> consumer) {
        Transaction transaction = session.beginTransaction();
        consumer.accept(session, item);
        transaction.commit();
    }

    public User findById(int id) {
        return session.get(User.class, id);
    }

    public void save(User user) {
        sessionDoWithTransaction(user, Session::save);
    }

    public void update(User user) {
        sessionDoWithTransaction(user, Session::update);
    }

    public void delete(User user) {
        sessionDoWithTransaction(user, Session::delete);
    }

    public Auto findAutoByGUId(UUID guid) {
        return session.get(Auto.class, guid);
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        for (Object o : session.createQuery("From User").list()) {
            users.add((User) o);
        }
        return users;
    }
}