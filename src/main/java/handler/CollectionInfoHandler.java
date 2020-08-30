package handler;

import dao.DaoController;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import parser.JsonParser;
import java.util.Map;

public class CollectionInfoHandler {
    private JsonParser jsonParser = new JsonParser();
    private DaoController daoController = new DaoController();

    public boolean addCollectionInfo(String jsonKey, String jsonData) throws ParseException {
        Map<String, JSONObject> jsonObjectMap = jsonParser.getParsedMap(jsonKey, jsonData);
        return daoController.invokeCollectionInfoWorker(jsonKey, jsonObjectMap);
    }
}
