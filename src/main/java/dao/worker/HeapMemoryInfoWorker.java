package dao.worker;

import org.json.simple.JSONObject;

import java.sql.Connection;
import java.util.Map;

public class HeapMemoryInfoWorker implements CollectionInfoWorker {
    private Connection connection;

    public HeapMemoryInfoWorker(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insertCollectionInfo(Map<String, JSONObject> jsonObjectMap) {
        System.out.println("HeapMemoryInfoWorker invoked");
        return true;
    }
}
