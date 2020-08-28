package dao.parser;

import org.json.simple.parser.JSONParser;

public class JsonParser {
    private JSONParser jsonParser;

    private JsonParser() {
        jsonParser = new JSONParser();
    }

    public static JSONParser getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final JSONParser INSTANCE = new JSONParser();
    }
}
