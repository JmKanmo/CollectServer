package parser;

import config.JsonKey;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class JsonParserTest {
    @Test
    public void testGerParsedMap() {
        assertNotNull(JsonParser.getInstance().getJsonParser());
    }

    @Test
    public void testGetParsedMap() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 4; i++) {
                        Map<String, JSONObject> jsonObjectMap = JsonParser.getInstance().getParsedMap("runTimeCollector&{\"runtimeInfo\":{\"upTime\":64414,\"vmversion\":\"11.0.7+10-LTS\",\"vmName\":\"OpenJDK 64-Bit Server VM\",\"name\":\"10140@DESKTOP-L5O6DA4\",\"startTime\":1598641320494,\"vmVendor\":\"Azul Systems, Inc.\"}}");
                        assertNotNull(jsonObjectMap.get(JsonKey.RUNTIME_COLLECTOR));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 4; i++) {
                        Map<String, JSONObject> jsonObjectMap = JsonParser.getInstance().getParsedMap("heapMemoryCollector&{\"runtimeInfo\":{\"upTime\":64414,\"vmversion\":\"11.0.7+10-LTS\",\"vmName\":\"OpenJDK 64-Bit Server VM\",\"name\":\"10140@DESKTOP-L5O6DA4\",\"startTime\":1598641320494,\"vmVendor\":\"Azul Systems, Inc.\"}}");
                        assertNotNull(jsonObjectMap.get(JsonKey.HEAP_MEMORY_COLLECTOR));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 4; i++) {
                        Map<String, JSONObject> jsonObjectMap = JsonParser.getInstance().getParsedMap("classLoadingCollector&{\"runtimeInfo\":{\"upTime\":64414,\"vmversion\":\"11.0.7+10-LTS\",\"vmName\":\"OpenJDK 64-Bit Server VM\",\"name\":\"10140@DESKTOP-L5O6DA4\",\"startTime\":1598641320494,\"vmVendor\":\"Azul Systems, Inc.\"}}");
                        assertNotNull(jsonObjectMap.get(JsonKey.CLASS_LOADING_COLLECTOR));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 4; i++) {
                        Map<String, JSONObject> jsonObjectMap = JsonParser.getInstance().getParsedMap("threadCollector&{\"runtimeInfo\":{\"upTime\":64414,\"vmversion\":\"11.0.7+10-LTS\",\"vmName\":\"OpenJDK 64-Bit Server VM\",\"name\":\"10140@DESKTOP-L5O6DA4\",\"startTime\":1598641320494,\"vmVendor\":\"Azul Systems, Inc.\"}}");
                        assertNotNull(jsonObjectMap.get(JsonKey.THREAD_COLLECTOR));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}