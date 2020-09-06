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
import org.json.simple.parser.ParseException;

public class DaoController {
    private Connection connection;

    public DaoController() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DBConfiguration.DRIVER_URL);
        } catch (ClassNotFoundException e) {
            throw e;
        }

        try {
            connection = DriverManager.getConnection(
                    DBConfiguration.DB_URL, DBConfiguration.DB_NAME,
                    DBConfiguration.DB_PASSWORD);
        } catch (SQLException e) {
            throw e;
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

    public boolean workCollectionInfoInsertion(CollectionInfoWorker collectionInfoWorker, Map<String, JSONObject> jsonObjectMap) throws SQLException, ParseException {
        return collectionInfoWorker.insertCollectionInfo(jsonObjectMap);
    }

    public boolean invokeCollectionInfoWorker(String jsonKey, Map<String, JSONObject> jsonObjectMap) throws SQLException, ParseException {
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
