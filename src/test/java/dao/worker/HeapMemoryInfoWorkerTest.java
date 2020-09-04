package dao.worker;

import dao.DaoController;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import java.util.Map;

import static org.junit.Assert.*;

@SuppressWarnings("unchecked")
public class HeapMemoryInfoWorkerTest {
    @Test
    public void insertCollectionInfo() throws ParseException {
        DaoController daoController = new DaoController();
        HeapMemoryInfoWorker heapMemoryInfoWorker = new HeapMemoryInfoWorker(daoController.getConnection());
        String data = "heapMemoryCollector&{\"heapMemory\":{\"init\":1073741824,\"max\":1033502720,\"used\":51548264,\"commited\":1033502720},\"nonHeapMemory\":{\"init\":7667712,\"max\":-1,\"used\":13935752,\"commited\":20250624},\"garbageCollection\":[{\"collectionTime\":0,\"name\":\"Copy\",\"collectionCount\":0,\"memoryPools\":[\"Eden Space\",\"Survivor Space\"]},{\"collectionTime\":0,\"name\":\"MarkSweepCompact\",\"collectionCount\":0,\"memoryPools\":[\"Eden Space\",\"Survivor Space\",\"Tenured Gen\"]}]}";
        String[] splited = data.split("&");
        assertNotNull(splited[0]);
        assertEquals(splited[1], "{\"heapMemory\":{\"init\":1073741824,\"max\":1033502720,\"used\":51548264,\"commited\":1033502720},\"nonHeapMemory\":{\"init\":7667712,\"max\":-1,\"used\":13935752,\"commited\":20250624},\"garbageCollection\":[{\"collectionTime\":0,\"name\":\"Copy\",\"collectionCount\":0,\"memoryPools\":[\"Eden Space\",\"Survivor Space\"]},{\"collectionTime\":0,\"name\":\"MarkSweepCompact\",\"collectionCount\":0,\"memoryPools\":[\"Eden Space\",\"Survivor Space\",\"Tenured Gen\"]}]}");
        Map<String, JSONObject> jsonObjectMap = (Map<String, JSONObject>) new JSONParser().parse(splited[1]);
        assertEquals(heapMemoryInfoWorker.insertCollectionInfo(jsonObjectMap), true);
    }
}