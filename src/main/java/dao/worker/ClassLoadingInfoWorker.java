package dao.worker;

import dao.sql.SqlUtils;
import logger.LoggingController;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class ClassLoadingInfoWorker implements CollectionInfoWorker {
    private Connection connection;

    public ClassLoadingInfoWorker(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean insertCollectionInfo(Map<String, JSONObject> jsonObjectMap) throws SQLException {
        try (
                PreparedStatement ps = (PreparedStatement) connection.prepareStatement(
                        SqlUtils.INSERT_CLASSLOADING_INFO);) {
            JSONObject jsonObject = jsonObjectMap.get("classLoadingInfo");
            ps.setInt(1, getNullOrNot(((Long) jsonObject.get("unloadedClassCount"))).intValue());
            ps.setInt(2, getNullOrNot(((Long) jsonObject.get("totalLoadedClassCount"))).intValue());
            ps.setInt(3, getNullOrNot(((Long) jsonObject.get("loadingClassCount"))).intValue());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
        return true;
    }
}
