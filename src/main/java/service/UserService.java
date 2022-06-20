package service;

import entity.UserEntity;
import model.User;

import java.util.List;
import java.util.function.Predicate;

public interface UserService {
    User save(User user);
    User findById(Integer id);
    boolean findUser(String username, String password);
    List<User> findAll();
    List<User> findAllBy(Predicate<UserEntity> predicate);
    User update(User entity, Integer id);
    String delete(Integer id);
}
