package mapper;

import entity.UserEntity;
import model.User;

public interface UserMapper {
    User entityToModel(UserEntity entity);
    UserEntity modelToEntity(User user);
}
