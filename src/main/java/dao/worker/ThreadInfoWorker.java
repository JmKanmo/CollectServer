package dao.worker;

import org.json.simple.JSONObject;

import java.sql.Connection;
import java.util.Map;

public class ThreadInfoWorker implements CollectionInfoWorker {
    private Connection connection;

    public ThreadInfoWorker(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insertCollectionInfo(Map<String, JSONObject> jsonObjectMap) {
        System.out.println("ThreadInfoWorker invoked");
        return true;
    }
}
