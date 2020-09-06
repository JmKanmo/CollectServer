package dao.worker;

import dao.DaoController;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import parser.JsonParser;

import java.sql.SQLException;
import java.util.Map;

import static org.junit.Assert.*;

public class ClassLoadingInfoWorkerTest {

    @Test
    public void insertCollectionInfo() throws ParseException, SQLException, ClassNotFoundException {
        DaoController daoController = new DaoController();
        ClassLoadingInfoWorker classLoadingInfoWorker = new ClassLoadingInfoWorker(daoController.getConnection());
        JsonParser jsonParser = new JsonParser();
        String data = "classLoadingCollector&{\"classLoadingInfo\":{\"unloadedClassCount\":0,\"totalLoadedClassCount\":1440,\"loadingClassCount\":1440}}";
        String[] splited = data.split("&");
        assertNotNull(splited[0]);
        assertEquals(splited[1], "{\"classLoadingInfo\":{\"unloadedClassCount\":0,\"totalLoadedClassCount\":1440,\"loadingClassCount\":1440}}");
        Map<String, JSONObject> jsonObjectMap = jsonParser.getParsedMap(splited[1]);
        assertNotNull(jsonObjectMap.get("classLoadingInfo"));
        assertEquals(classLoadingInfoWorker.insertCollectionInfo(jsonObjectMap), true);
    }
}