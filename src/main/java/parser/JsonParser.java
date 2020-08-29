package parser;

import config.JsonKey;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;

public class JsonParser {
    private JSONParser jsonParser;

    public JSONParser getJsonParser() {
        return jsonParser;
    }

    private JsonParser() {
        jsonParser = new JSONParser();
    }

    public static JsonParser getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final JsonParser INSTANCE = new JsonParser();
    }

    public Map<String, JSONObject> getParsedMap(String data) throws ParseException {
        String[] splited = data.split("&");
        Map<String, JSONObject> parsedMap = new HashMap<>();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(splited[1]);

        switch (splited[0]) {
            case JsonKey.HEAP_MEMORY_COLLECTOR: {
                parsedMap.put(JsonKey.HEAP_MEMORY_COLLECTOR, jsonObject);
                break;
            }
            case JsonKey.THREAD_COLLECTOR: {
                parsedMap.put(JsonKey.THREAD_COLLECTOR, jsonObject);
                break;
            }
            case JsonKey.CLASS_LOADING_COLLECTOR: {
                parsedMap.put(JsonKey.CLASS_LOADING_COLLECTOR, jsonObject);
                break;
            }
            case JsonKey.RUNTIME_COLLECTOR: {
                parsedMap.put(JsonKey.RUNTIME_COLLECTOR, jsonObject);
                break;
            }
        }
        return parsedMap;
    }
}
