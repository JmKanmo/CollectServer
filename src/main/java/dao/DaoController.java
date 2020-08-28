package dao;

import config.DBConfiguration;
import logger.LoggingController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoController {
    private Connection connection;

    public DaoController() {
        init();
    }

    public void init() {
        try {
            Class.forName(DBConfiguration.DRIVER_URL);
        } catch (ClassNotFoundException e) {
            LoggingController.errorLogging(e);
            return;
        }

        try {
            connection = DriverManager.getConnection(
                    DBConfiguration.DB_URL, DBConfiguration.DB_NAME,
                    DBConfiguration.DB_PASSWORD);
        } catch (SQLException e) {
            LoggingController.errorLogging(e);
            return;
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
