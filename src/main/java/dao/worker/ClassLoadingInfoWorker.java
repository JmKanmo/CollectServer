package dao.worker;

import org.json.simple.JSONObject;

import java.sql.Connection;
import java.util.Map;

public class ClassLoadingInfoWorker implements CollectionInfoWorker {
    private Connection connection;

    public ClassLoadingInfoWorker(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insertCollectionInfo(Map<String, JSONObject> jsonObjectMap) {
        System.out.println("ClassLoadingInfoWorker invoked");
        return true;
    }
}
