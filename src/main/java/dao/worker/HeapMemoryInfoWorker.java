package dao.worker;

import org.json.simple.JSONObject;

import java.sql.Connection;
import java.util.Map;

public class HeapMemoryInfoInfoWorker implements CollectionInfoWorker {
    private Connection connection;

    public HeapMemoryInfoInfoWorker(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insertCollectionInfo(Map<String, JSONObject> jsonObjectMap) {
        return false;
    }
}
