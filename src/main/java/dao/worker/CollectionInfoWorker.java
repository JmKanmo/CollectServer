package dao.worker;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public interface CollectionInfoWorker {
    default Long getNullOrNot(Long value) {
        if (value == null) {
            return 0L;
        } else {
            return value;
        }
    }

    default Integer getNullOrNot(Integer value) {
        if (value == null) {
            return 0;
        } else {
            return value;
        }
    }

    default String getNullOrNot(String value) {
        if (value == null) {
            return "undefined";
        } else {
            return value;
        }
    }

    public boolean insertCollectionInfo(Map<String, JSONObject> jsonObjectMap) throws SQLException, ParseException;
}
