package dao;

import database.CrudOperations;
import entity.ProductEntity;

import java.util.List;
import java.util.function.Predicate;

public interface ProductDao extends CrudOperations<ProductEntity, Integer> {
    List<ProductEntity> findAllBy(Predicate<ProductEntity> predicate);
}
