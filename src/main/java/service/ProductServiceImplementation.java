package service;

import dao.ProductDao;
import dao.ProductDaoImplementation;
import entity.ProductEntity;
import mapper.ProductEntityMapper;
import mapper.ProductMapper;
import model.Product;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductServiceImplementation implements ProductService{
    private final ProductDao productDao = new ProductDaoImplementation();
    private final ProductMapper productMapper = new ProductEntityMapper();

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productMapper.modelToEntity(product);
        ProductEntity savedProductEntity = this.productDao.save(productEntity);
        return product;
    }

    @Override
    public Product findById(Integer id) {
        Optional<ProductEntity> entityOptional = this.productDao.findById(id);
        if (entityOptional.isEmpty()) {
            throw new RuntimeException("Product with id: " + id + " was not found!");
        }

        ProductEntity productEntity = entityOptional.get();
        return productMapper.entityToModel(productEntity);

    }

    @Override
    public List<Product> findAll() {
        List<ProductEntity> productEntityList = this.productDao.findAll();
        return productEntityList.stream()
                .map(productMapper::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findAllBy(Predicate<ProductEntity> predicate) {

        return this.productDao.findAllBy(predicate).stream()
                .map(productMapper::entityToModel)
                .collect(Collectors.toList());
    }


    @Override
    public Product update(Product product, Integer id) {
        Optional<ProductEntity> optionalProductEntity = this.productDao.update(productMapper.modelToEntity(product), id);
        if (optionalProductEntity.isEmpty()) {
            throw new RuntimeException("Product with id: " + id + " was not found!");
        }
        return productMapper.entityToModel(optionalProductEntity.get());
    }

    @Override
    public String delete(Integer id) {
        this.productDao.delete(id);
        return "Product has been deleted successfully!";
    }
}
