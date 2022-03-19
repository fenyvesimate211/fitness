package database;

import model.User;

import java.util.List;
import java.util.function.Predicate;

public class UserServiceImplementation implements UserService {

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAllBy(Predicate<UserEntity> predicate) {
        return null;
    }

    @Override
    public User update(User entity, Integer id) {
        return null;
    }

    @Override
    public String delete(Integer id) {
        return null;
    }
}
