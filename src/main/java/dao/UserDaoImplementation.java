package dao;

import database.ConnectionManager;
import entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserDaoImplementation implements UserDao {
    private final ConnectionManager connectionManager = ConnectionManager.getInstance();
    private final Connection connection = connectionManager.getConnection();

    @Override
    public UserEntity save(UserEntity entity) {
        final String SQL = "INSERT INTO users (name, email, password, gender, dateOfBirth, weight, height, dailyGoal) VALUE (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            saveFields(entity, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public Optional<UserEntity> findById(Integer id) {
        final String SQL = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    UserEntity userEntity = findFields(resultSet);
                    return Optional.of(userEntity);
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
    public List<UserEntity> findAll() {
        List<UserEntity> userEntityList = new ArrayList<>();
        final String SQL = "SELECT * FROM users;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    UserEntity userEntity = findFields(resultSet);
                    userEntityList.add(userEntity);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connectionManager.close();
        }
        return userEntityList;
    }

    @Override
    public Optional<UserEntity> update(UserEntity entity, Integer id) {
        final String SQL = "UPDATE users SET name = ? , email = ? , password = ? , gender = ? ," +
                " dateOfBirth = ? , weight = ? , height = ? , dailyGoal = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            saveFields(entity, preparedStatement);
            preparedStatement.setInt(9, id);
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
        final String SQL = "DELETE FROM users WHERE id = ?";
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
    public List<UserEntity> findAllBy(Predicate<UserEntity> predicate) {
        List<UserEntity> userEntityList = findAll();
        return userEntityList.stream().filter(predicate).collect(Collectors.toList());
    }

    private UserEntity findFields(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String email = resultSet.getString(3);
        String password = resultSet.getString(4);
        String gender = resultSet.getString(5);
        String dateOfBirth = resultSet.getString(6);
        int weight = resultSet.getInt(7);
        int height = resultSet.getInt(8);
        int dailyGoal = resultSet.getInt(9);
        return new UserEntity(userId, name, email, password, gender, dateOfBirth, weight, height, dailyGoal);
    }

    private void saveFields(UserEntity entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getEmail());
        preparedStatement.setString(3, entity.getPassword());
        preparedStatement.setString(4, entity.getGender());
        preparedStatement.setString(5, entity.getDateOfBirth());
        preparedStatement.setInt(6, entity.getWeight());
        preparedStatement.setInt(7, entity.getHeight());
        preparedStatement.setInt(8, entity.getDailyGoal());
    }
}
