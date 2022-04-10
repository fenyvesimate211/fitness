package dao;

import database.CrudOperations;
import entity.UserEntity;

import java.util.List;
import java.util.function.Predicate;

public interface UserDao extends CrudOperations<UserEntity, Integer> {
    List<UserEntity> findAllBy(Predicate<UserEntity> predicate);
}