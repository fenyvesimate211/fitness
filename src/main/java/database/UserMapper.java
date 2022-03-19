package database;

import model.User;

public interface UserMapper {
    User entityToModel(UserEntity entity);
    UserEntity modelToEntity(User user);
}
