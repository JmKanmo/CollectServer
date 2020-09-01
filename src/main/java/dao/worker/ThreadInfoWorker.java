package dao.worker;

import dao.sql.SqlUtils;
import logger.LoggingController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

@SuppressWarnings("unchecked")
public class ThreadInfoWorker implements CollectionInfoWorker {
    private Connection connection;

    public ThreadInfoWorker(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insertCollectionInfo(Map<String, JSONObject> jsonObjectMap) {
        try (PreparedStatement overallThreadInfoPS = (PreparedStatement) connection.prepareStatement(
                SqlUtils.INSERT_OVERALL_THREAD_INFO);
             PreparedStatement allThreadInfoPS = (PreparedStatement) connection.prepareStatement(
                     SqlUtils.INSERT_ALL_THREAD_INFO);
        ) {
            JSONObject overallInfoJsonObject = jsonObjectMap.get("overallInfo");
            JSONObject allThreadInfoJsonObject = (JSONObject) new JSONParser().parse(jsonObjectMap.toString());

            overallThreadInfoPS.setInt(1, getNullOrNot(((Long) overallInfoJsonObject.get("TotalStartedThreadCount"))).intValue());
            overallThreadInfoPS.setInt(2, getNullOrNot(((Long) overallInfoJsonObject.get("PeakThreadCount"))).intValue());
            overallThreadInfoPS.setInt(3, getNullOrNot(((Long) overallInfoJsonObject.get("DaemonThreadCount"))).intValue());
            overallThreadInfoPS.executeUpdate();

            JSONArray jsonArray = (JSONArray) allThreadInfoJsonObject.get("allThread");

            jsonArray.forEach(jsonData -> {
                JSONObject castedJsonObj = (JSONObject) jsonData;

                try {
                    allThreadInfoPS.setString(1, getNullOrNot((String) castedJsonObj.get("name")));
                    allThreadInfoPS.setString(2, getNullOrNot((String) castedJsonObj.get("state")));
                    allThreadInfoPS.setInt(3, getNullOrNot(((Long) castedJsonObj.get("waitCount")).intValue()));
                    allThreadInfoPS.setString(4, getNullOrNot((String) castedJsonObj.get("lockName")));
                    allThreadInfoPS.executeUpdate();
                } catch (SQLException throwables) {
                    LoggingController.errorLogging(throwables);
                }
            });
        } catch (Exception e) {
            LoggingController.errorLogging(e);
            return false;
        }
        return true;
    }
}
