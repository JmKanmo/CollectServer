package dao;

import config.DBConfiguration;
import dao.worker.*;
import logger.LoggingController;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import config.JsonKey;

public class DaoController {
    private Connection connection;

    public DaoController() {
        init();
    }

    private void init() {
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

    public void close() throws SQLException {
        if (connection != null && connection.isClosed() != true) {
            connection.close();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    private boolean workCollectionInfoInsertion(CollectionInfoWorker collectionInfoWorker, Map<String, JSONObject> jsonObjectMap) {
        return collectionInfoWorker.insertCollectionInfo(jsonObjectMap);
    }

    public boolean invokeCollectionInfoWorker(String jsonKey, Map<String, JSONObject> jsonObjectMap) {
        switch (jsonKey) {
            case JsonKey.HEAP_MEMORY_COLLECTOR:
                return workCollectionInfoInsertion(new HeapMemoryInfoWorker(connection), jsonObjectMap);

            case JsonKey.RUNTIME_COLLECTOR:
                return workCollectionInfoInsertion(new RunTimeInfoWorker(connection), jsonObjectMap);

            case JsonKey.THREAD_COLLECTOR:
                return workCollectionInfoInsertion(new ThreadInfoWorker(connection), jsonObjectMap);

            case JsonKey.CLASS_LOADING_COLLECTOR:
                return workCollectionInfoInsertion(new ClassLoadingInfoWorker(connection), jsonObjectMap);
        }
        return false;
    }
}
