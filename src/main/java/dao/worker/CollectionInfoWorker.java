package dao.worker;

import org.json.simple.JSONObject;

import java.sql.Connection;
import java.util.Map;

public interface CollectionInfoWorker {
    public boolean insertCollectionInfo(Map<String, JSONObject> jsonObjectMap);
}
