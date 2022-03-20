package Service;

import Entity.UserEntity;
import Mapper.UserEntityMapper;
import Mapper.UserMapper;
import dao.UserDao;
import dao.UserDaoImplementation;
import model.User;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserServiceImplementation implements UserService {
    private final UserDao userDao = new UserDaoImplementation();
    private final UserMapper userMapper = new UserEntityMapper();

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.modelToEntity(user);
        UserEntity savedUserEntity = this.userDao.save(userEntity);
        return user;
    }

    @Override
    public User findById(Integer id) {
        Optional<UserEntity> entityOptional = this.userDao.findById(id);
        if (entityOptional.isEmpty()) {
            throw new RuntimeException("User with id: " + id + " was not found!");
        }

        UserEntity userEntity = entityOptional.get();
        return userMapper.entityToModel(userEntity);

    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntityList = this.userDao.findAll();
        return userEntityList.stream().map(userMapper::entityToModel).collect(Collectors.toList());

    }

    @Override
    public List<User> findAllBy(Predicate<UserEntity> predicate) {

        return this.userDao.findAllBy(predicate).stream()
                .map(userMapper::entityToModel)
                .collect(Collectors.toList());
    }


    @Override
    public User update(User user, Integer id) {
        Optional<UserEntity> optionalUserEntity = this.userDao.update(userMapper.modelToEntity(user), id);
        if (optionalUserEntity.isEmpty()) {
            throw new RuntimeException("User with id: " + id + " was not found!");
        }
        return userMapper.entityToModel(optionalUserEntity.get());
    }

    @Override
    public String delete(Integer id) {
        this.userDao.delete(id);
        return "User has been deleted successfully!";
    }
}
