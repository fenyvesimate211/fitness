package mapper;

import entity.ProductEntity;
import model.Product;

public class ProductEntityMapper implements ProductMapper{
    @Override
    public Product entityToModel(ProductEntity entity) {
        return new Product(entity.getId() ,entity.getProduct(), entity.getEnergy(), entity.getProtein(), entity.getFat(),
                entity.getCarbs(), entity.getSugar(), entity.getFiber());
    }

    @Override
    public ProductEntity modelToEntity(Product product){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setProduct(product.getProduct());
        productEntity.setEnergy(product.getEnergy());
        productEntity.setProtein(product.getProtein());
        productEntity.setFat(product.getFat());
        productEntity.setCarbs(product.getCarbs());
        productEntity.setSugar(product.getSugar());
        productEntity.setFiber(product.getFiber());
        return productEntity;
    }
}
