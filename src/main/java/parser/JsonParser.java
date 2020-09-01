package parser;

import config.JsonKey;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;

public class JsonParser {
    private JSONParser jsonParser;

    public JsonParser() {
        jsonParser = new JSONParser();
    }

    public JSONParser getJsonParser() {
        return jsonParser;
    }

    public Map<String, JSONObject> getParsedMap(String jsonKey, String jsonData) throws ParseException {
        Map<String, JSONObject> parsedMap = new HashMap<>();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonData);

        switch (jsonKey) {
            case JsonKey.HEAP_MEMORY_COLLECTOR: {
                parsedMap.put(JsonKey.HEAP_MEMORY_COLLECTOR, jsonObject);
                return parsedMap.get("heapMemoryCollector");
            }
            case JsonKey.THREAD_COLLECTOR: {
                parsedMap.put(JsonKey.THREAD_COLLECTOR, jsonObject);
                return parsedMap.get("threadCollector");
            }
            case JsonKey.CLASS_LOADING_COLLECTOR: {
                parsedMap.put(JsonKey.CLASS_LOADING_COLLECTOR, jsonObject);
                return parsedMap.get("classLoadingCollector");
            }
            case JsonKey.RUNTIME_COLLECTOR: {
                parsedMap.put(JsonKey.RUNTIME_COLLECTOR, jsonObject);
                return parsedMap.get("runTimeCollector");
            }
        }
        return parsedMap;
    }
}
