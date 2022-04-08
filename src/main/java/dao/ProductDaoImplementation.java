package dao;

import database.ConnectionManager;
import entity.ProductEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductDaoImplementation implements ProductDao{
    private final ConnectionManager connectionManager = ConnectionManager.getInstance();
    private final Connection connection = connectionManager.getConnection();

    @Override
    public ProductEntity save(ProductEntity entity) {
        final String SQL = "INSERT INTO products (product, energy, protein, fat, carbs, sugar, fiber) VALUE (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            saveFields(entity, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public Optional<ProductEntity> findById(Integer id) {
        final String SQL = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    ProductEntity productEntity = findFields(resultSet);
                    return Optional.of(productEntity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionManager.close();
        }
        return Optional.empty();
    }

    @Override
    public List<ProductEntity> findAll() {
        List<ProductEntity> productEntityList = new ArrayList<>();
        final String SQL = "SELECT * FROM products;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    ProductEntity productEntity = findFields(resultSet);
                    productEntityList.add(productEntity);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connectionManager.close();
        }
        return productEntityList;
    }

    @Override
    public Optional<ProductEntity> update(ProductEntity entity, Integer id) {
        final String SQL = "UPDATE products SET product = ? , energy = ? , protein = ? , fat = ? ," +
                " carbs = ? , sugar = ? , fiber = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            saveFields(entity, preparedStatement);
            preparedStatement.setInt(8, id);
            int n = preparedStatement.executeUpdate();
            if (n > 0) {
                return Optional.of(entity);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connectionManager.close();
        }
        return Optional.empty();
    }

    @Override
    public void delete(Integer id) {
        final String SQL = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connectionManager.close();
        }
    }

    @Override
    public List<ProductEntity> findAllBy(Predicate<ProductEntity> predicate) {
        List<ProductEntity> productEntityList = findAll();
        return productEntityList.stream().filter(predicate).collect(Collectors.toList());
    }

    private ProductEntity findFields(ResultSet resultSet) throws SQLException {
        int productId = resultSet.getInt(1);
        String product = resultSet.getString(2);
        int energy = resultSet.getInt(3);
        int protein = resultSet.getInt(4);
        int fat = resultSet.getInt(5);
        int carbs = resultSet.getInt(6);
        int sugar = resultSet.getInt(7);
        int fiber = resultSet.getInt(8);
        return new ProductEntity(productId, product, energy, protein, fat, carbs, sugar, fiber);
    }

    private void saveFields(ProductEntity entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getProduct());
        preparedStatement.setDouble(2, entity.getEnergy());
        preparedStatement.setDouble(3, entity.getProtein());
        preparedStatement.setDouble(4, entity.getFat());
        preparedStatement.setDouble(5, entity.getCarbs());
        preparedStatement.setDouble(6, entity.getSugar());
        preparedStatement.setDouble(7, entity.getFiber());
    }
}
