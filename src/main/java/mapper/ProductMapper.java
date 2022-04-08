package mapper;

import entity.ProductEntity;
import model.Product;

public interface ProductMapper {
    Product entityToModel(ProductEntity entity);
    ProductEntity modelToEntity(Product product);
}
