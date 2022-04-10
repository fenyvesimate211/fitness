package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static ConnectionManager instance;
    private Connection connection;

//    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fitness");
//
//    public static EntityManager getEntityManager() {
//        return entityManagerFactory.createEntityManager();
//    }

    private ConnectionManager() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/dbconfig.properties"));
            this.connection = DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("username"), properties.getProperty("password"));
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        if (this.connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }



    public static ConnectionManager getInstance() {
        try {
            if (instance == null || instance.connection.isClosed()) {
                synchronized (ConnectionManager.class) {
                    if (instance == null || instance.connection.isClosed()) {
                        instance = new ConnectionManager();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }
}
