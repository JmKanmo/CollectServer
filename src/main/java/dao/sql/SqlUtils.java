package dao.sql;

public class SqlUtils {
    public static final String INSERT_RUNTIME_INFO = "INSERT INTO runtimeinfo (uptime,vmvendor,vmname,name,starttime,vmversion) VALUES (?,?,?,?,?,?);";
    public static final String INSERT_CLASSLOADING_INFO = "INSERT INTO classloadinginfo (unloadedclasscount,totalloadedclasscount,loadingclasscount) VALUES (?,?,?);";
    public static final String 
}
