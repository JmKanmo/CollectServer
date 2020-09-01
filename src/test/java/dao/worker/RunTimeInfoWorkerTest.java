package dao.worker;

import dao.DaoController;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import parser.JsonParser;

import java.util.Map;

import static org.junit.Assert.*;

public class RunTimeInfoWorkerTest {

    @Test
    public void insertCollectionInfo() throws ParseException {
        DaoController daoController = new DaoController();
        RunTimeInfoWorker runTimeInfoWorker = new RunTimeInfoWorker(daoController.getConnection());
        JsonParser jsonParser = new JsonParser();
        String data = "runTimeCollector&{\"runtimeInfo\":{\"upTime\":334,\"vmversion\":\"11.0.7+10-LTS\",\"vmName\":\"OpenJDK 64-Bit Server VM\",\"name\":\"14789@localhost.localdomain\",\"startTime\":1598656544999,\"vmVendor\":\"Azul Systems, Inc.\"}}";
        String[] splited = data.split("&");
        assertNotNull(splited[0]);
        assertEquals(splited[1], "{\"runtimeInfo\":{\"upTime\":334,\"vmversion\":\"11.0.7+10-LTS\",\"vmName\":\"OpenJDK 64-Bit Server VM\",\"name\":\"14789@localhost.localdomain\",\"startTime\":1598656544999,\"vmVendor\":\"Azul Systems, Inc.\"}}");
        Map<String, JSONObject> jsonObjectMap = jsonParser.getParsedMap(splited[0], splited[1]);
        assertNotNull(jsonObjectMap.get("runtimeInfo"));
        assertEquals(runTimeInfoWorker.insertCollectionInfo(jsonObjectMap), true);
    }
}