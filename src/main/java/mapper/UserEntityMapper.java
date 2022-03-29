package mapper;

import entity.UserEntity;
import model.User;

public class UserEntityMapper implements UserMapper {
    @Override
    public User entityToModel(UserEntity entity) {
        return new User(entity.getName(), entity.getEmail(), entity.getPassword(), entity.getGender(),
                entity.getDateOfBirth(), entity.getWeight(), entity.getHeight(), entity.getDailyGoal());
    }

    @Override
    public UserEntity modelToEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setDateOfBirth(user.getDateOfBirth());
        userEntity.setGender(user.getGender());
        userEntity.setWeight(user.getWeight());
        userEntity.setHeight(user.getHeight());
        userEntity.setDailyGoal(user.getDailyGoal());
        return userEntity;
    }
}
