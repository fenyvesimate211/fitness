package service;

import entity.ProductEntity;
import model.Product;

import java.util.List;
import java.util.function.Predicate;

public interface ProductService {
    Product save(Product product);
    Product findById(Integer id);
    List<Product> findAll();
    List<Product> findAllBy(Predicate<ProductEntity> predicate);
    Product update(Product product, Integer id);
    String delete(Integer id);
}
