package dao.worker;

import dao.sql.SqlUtils;
import logger.LoggingController;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class RunTimeInfoWorker implements CollectionInfoWorker {
    private Connection connection;

    public RunTimeInfoWorker(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insertCollectionInfo(Map<String, JSONObject> jsonObjectMap) throws SQLException {
        try (
                PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
                        SqlUtils.INSERT_RUNTIME_INFO);) {
            JSONObject jsonObject = jsonObjectMap.get("runtimeInfo");
            ps.setInt(1, getNullOrNot(((Long) jsonObject.get("upTime"))).intValue());
            ps.setString(2, getNullOrNot((String) jsonObject.get("vmVendor")));
            ps.setString(3, getNullOrNot((String) jsonObject.get("vmName")));
            ps.setString(4, getNullOrNot((String) jsonObject.get("name")));
            ps.setInt(5, getNullOrNot(((Long) jsonObject.get("startTime"))).intValue());
            ps.setString(6, getNullOrNot((String) jsonObject.get("vmversion")));
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
        return true;
    }
}
