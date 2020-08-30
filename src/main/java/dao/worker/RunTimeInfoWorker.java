package dao.worker;

import org.json.simple.JSONObject;

import java.sql.Connection;
import java.util.Map;

public class RunTimeInfoWorker implements CollectionInfoWorker {
    private Connection connection;

    public RunTimeInfoWorker(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insertCollectionInfo(Map<String, JSONObject> jsonObjectMap) {
        System.out.println("RunTimeInfoWorker invoked");
        return true;
    }
}
