package parser;

import config.JsonKey;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.util.Map;

public class JsonParserTest {
    @Test
    public void testGetParsedMap() {
        String str = "runTimeCollector&{\"runtimeInfo\":{\"upTime\":64414,\"vmversion\":\"11.0.7+10-LTS\",\"vmName\":\"OpenJDK 64-Bit Server VM\",\"name\":\"10140@DESKTOP-L5O6DA4\",\"startTime\":1598641320494,\"vmVendor\":\"Azul Systems, Inc.\"}}";
        String[] splited = str.split("&");

        try {
            JsonParser jsonParser = new JsonParser();
            Map<String, JSONObject> jsonObjectMap = jsonParser.getParsedMap(splited[1]);
            System.out.println(jsonObjectMap);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}