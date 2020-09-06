package dao.worker;

import dao.sql.SqlUtils;
import logger.LoggingController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

@SuppressWarnings("unchecked")
public class HeapMemoryInfoWorker implements CollectionInfoWorker {
    private Connection connection;

    public HeapMemoryInfoWorker(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insertCollectionInfo(Map<String, JSONObject> jsonObjectMap) throws ParseException, SQLException {
        try (
                PreparedStatement heapMemoryInfoPS = (PreparedStatement) connection.prepareStatement(
                        SqlUtils.INSERT_HEAP_MEMORY_INFO);

                PreparedStatement nonHeapMemoryInfoPS = (PreparedStatement) connection.prepareStatement(
                        SqlUtils.INSERT_NONHEAP_MEMORY_INFO);

                PreparedStatement garbageCollectionPS = connection.prepareStatement(SqlUtils.INSERT_GARBAGE_COLLECTION_INFO);
        ) {
            JSONObject heapMemoryInfoJsonObject = jsonObjectMap.get("heapMemory");
            JSONObject nonHeapMemoryInfoJsonObject = jsonObjectMap.get("nonHeapMemory");
            JSONObject garbageCollectionInfoJsonObject = (JSONObject) new JSONParser().parse(jsonObjectMap.toString());

            heapMemoryInfoPS.setInt(1, getNullOrNot(((Long) heapMemoryInfoJsonObject.get("max"))).intValue());
            heapMemoryInfoPS.setInt(2, getNullOrNot(((Long) heapMemoryInfoJsonObject.get("used"))).intValue());
            heapMemoryInfoPS.setInt(3, getNullOrNot(((Long) heapMemoryInfoJsonObject.get("commited"))).intValue());
            heapMemoryInfoPS.setInt(4, getNullOrNot(((Long) heapMemoryInfoJsonObject.get("init"))).intValue());
            heapMemoryInfoPS.executeUpdate();

            nonHeapMemoryInfoPS.setInt(1, getNullOrNot(((Long) nonHeapMemoryInfoJsonObject.get("max"))).intValue());
            nonHeapMemoryInfoPS.setInt(2, getNullOrNot(((Long) nonHeapMemoryInfoJsonObject.get("used"))).intValue());
            nonHeapMemoryInfoPS.setInt(3, getNullOrNot(((Long) nonHeapMemoryInfoJsonObject.get("commited"))).intValue());
            nonHeapMemoryInfoPS.setInt(4, getNullOrNot(((Long) nonHeapMemoryInfoJsonObject.get("init"))).intValue());
            nonHeapMemoryInfoPS.executeUpdate();

            JSONArray jsonArray = (JSONArray) garbageCollectionInfoJsonObject.get("garbageCollection");

            for (Object object : jsonArray) {
                JSONObject castedJsonObj = (JSONObject) object;

                try {
                    garbageCollectionPS.setInt(1, getNullOrNot(((Long) castedJsonObj.get("collectiontime"))).intValue());
                    garbageCollectionPS.setString(2, getNullOrNot((String) castedJsonObj.get("name")));
                    garbageCollectionPS.setInt(3, getNullOrNot(((Long) castedJsonObj.get("collectioncount"))).intValue());

                    JSONArray jsonArr = (JSONArray) castedJsonObj.get("memoryPools");
                    String[] strArr = Arrays.stream(jsonArr.toArray()).map(Object::toString).toArray(String[]::new);
                    Array array = connection.createArrayOf("text", strArr);

                    garbageCollectionPS.setArray(4, array);
                    garbageCollectionPS.executeUpdate();
                } catch (SQLException e) {
                    throw e;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return true;
    }
}
