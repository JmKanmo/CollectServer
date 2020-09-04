package parser;

import config.JsonKey;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class JsonParser {

    public Map<String, JSONObject> getParsedMap(String jsonData) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        Map<String, JSONObject> jsonObjectMap = (JSONObject) jsonParser.parse(jsonData);
        return jsonObjectMap;
    }
}
