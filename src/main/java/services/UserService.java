package services;

import dao.UserDao;
import models.Auto;
import models.User;

import java.io.Closeable;
import java.util.List;
import java.util.UUID;

public class UserService implements Closeable {

    private final UserDao usersDao;

    public UserService() {
        usersDao = new UserDao();
    }

    public User findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public Auto findAutoByGUId(UUID guid) {
        return usersDao.findAutoByGUId(guid);
    }

    @Override
    public void close() {
        usersDao.close();
    }
}