package dao.sql;

public class SqlUtils {
    public static final String INSERT_RUNTIME_INFO = "INSERT INTO runtimeinfo (uptime,vmvendor,vmname,name,starttime,vmversion) VALUES (?,?,?,?,?,?);";
    public static final String INSERT_CLASSLOADING_INFO = "INSERT INTO classloadinginfo (unloadedclasscount,totalloadedclasscount,loadingclasscount) VALUES (?,?,?);";
    public static final String INSERT_OVERALL_THREAD_INFO = "INSERT INTO overallthreadinfo (totalstartedthreadcount,peakthreadcount,daemonthreadcount) VALUES (?,?,?);";
    public static final String INSERT_ALL_THREAD_INFO = "INSERT INTO allthreadinfo (name,state,waitcount,lockname) values (?,?,?,?);";
    public static final String INSERT_HEAP_MEMORY_INFO = "INSERT INTO heapmemoryinfo (max,used,commited,init) values(?,?,?,?);";
    public static final String INSERT_NONHEAP_MEMORY_INFO = "INSERT INTO nonheapmemoryinfo (max,used,commited,init) values(?,?,?,?);";
    public static final String INSERT_GARBAGE_COLLECTION_INFO = "INSERT INTO garbagecollectioninfo (collectiontime,name,collectioncount,memorypools) values(?,?,?,?);";
}
