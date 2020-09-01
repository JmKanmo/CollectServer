package dao.worker;

import dao.DaoController;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import parser.JsonParser;

import java.util.Map;

import static org.junit.Assert.*;

@SuppressWarnings("unchecked")
public class ThreadInfoWorkerTest {
    @Test
    public void insertCollectionInfo() throws ParseException {
        DaoController daoController = new DaoController();
        ThreadInfoWorker threadInfoWorker = new ThreadInfoWorker(daoController.getConnection());
        JsonParser jsonParser = new JsonParser();
        String data = "threadCollector&{\"allThread\":[{\"name\":\"main\",\"id\":1,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"Reference Handler\",\"id\":2,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"Finalizer\",\"id\":3,\"state\":\"WAITING\",\"waitCount\":2,\"lockName\":\"java.lang.ref.ReferenceQueue$Lock@15ec0bb3\"},{\"name\":\"Signal Dispatcher\",\"id\":4,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"Common-Cleaner\",\"id\":8,\"state\":\"TIMED_WAITING\",\"waitCount\":2,\"lockName\":\"java.lang.ref.ReferenceQueue$Lock@11d38dd6\"},{\"name\":\"Thread-1\",\"id\":10,\"state\":\"WAITING\",\"waitCount\":2,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@54d10188\"},{\"name\":\"FileSystemWatchService\",\"id\":13,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"AsyncFileHandlerWriter-905654280\",\"id\":16,\"state\":\"TIMED_WAITING\",\"waitCount\":33,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@100bc362\"},{\"name\":\"classLoadingCollector\",\"id\":11,\"state\":\"TIMED_WAITING\",\"waitCount\":3},{\"name\":\"heapMemoryCollector\",\"id\":18,\"state\":\"TIMED_WAITING\",\"waitCount\":2},{\"name\":\"runTimeCollector\",\"id\":20,\"state\":\"TIMED_WAITING\",\"waitCount\":2},{\"name\":\"threadCollector\",\"id\":22,\"state\":\"RUNNABLE\",\"waitCount\":1},{\"name\":\"FileHandlerLogFilesCleaner-1\",\"id\":24,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@20fcc417\"},{\"name\":\"RMI TCP Accept-0\",\"id\":25,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"RMI TCP Accept-82\",\"id\":26,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"RMI TCP Accept-0\",\"id\":27,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"NioBlockingSelector.BlockPoller-1\",\"id\":28,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"NioBlockingSelector.BlockPoller-2\",\"id\":29,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"ContainerBackgroundProcessor[StandardEngine[Catalina]]\",\"id\":30,\"state\":\"TIMED_WAITING\",\"waitCount\":1},{\"name\":\"http-nio-8080-exec-1\",\"id\":31,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-2\",\"id\":32,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-3\",\"id\":33,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-4\",\"id\":34,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-5\",\"id\":35,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-6\",\"id\":36,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-7\",\"id\":37,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-8\",\"id\":38,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-9\",\"id\":39,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-10\",\"id\":40,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-ClientPoller-0\",\"id\":41,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"http-nio-8080-Acceptor-0\",\"id\":42,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"http-nio-8080-AsyncTimeout\",\"id\":43,\"state\":\"TIMED_WAITING\",\"waitCount\":7},{\"name\":\"ajp-nio-8009-exec-1\",\"id\":44,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-2\",\"id\":45,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-3\",\"id\":46,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-4\",\"id\":47,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-5\",\"id\":48,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-6\",\"id\":49,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-7\",\"id\":50,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-8\",\"id\":51,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-9\",\"id\":52,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-10\",\"id\":53,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-ClientPoller-0\",\"id\":54,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"ajp-nio-8009-Acceptor-0\",\"id\":55,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"ajp-nio-8009-AsyncTimeout\",\"id\":56,\"state\":\"TIMED_WAITING\",\"waitCount\":7}],\"overallInfo\":{\"TotalStartedThreadCount\":46,\"PeakThreadCount\":45,\"DaemonThreadCount\":44}}";
        String[] splited = data.split("&");

        assertNotNull(splited[0]);
        assertEquals(splited[1], "{\"allThread\":[{\"name\":\"main\",\"id\":1,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"Reference Handler\",\"id\":2,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"Finalizer\",\"id\":3,\"state\":\"WAITING\",\"waitCount\":2,\"lockName\":\"java.lang.ref.ReferenceQueue$Lock@15ec0bb3\"},{\"name\":\"Signal Dispatcher\",\"id\":4,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"Common-Cleaner\",\"id\":8,\"state\":\"TIMED_WAITING\",\"waitCount\":2,\"lockName\":\"java.lang.ref.ReferenceQueue$Lock@11d38dd6\"},{\"name\":\"Thread-1\",\"id\":10,\"state\":\"WAITING\",\"waitCount\":2,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@54d10188\"},{\"name\":\"FileSystemWatchService\",\"id\":13,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"AsyncFileHandlerWriter-905654280\",\"id\":16,\"state\":\"TIMED_WAITING\",\"waitCount\":33,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@100bc362\"},{\"name\":\"classLoadingCollector\",\"id\":11,\"state\":\"TIMED_WAITING\",\"waitCount\":3},{\"name\":\"heapMemoryCollector\",\"id\":18,\"state\":\"TIMED_WAITING\",\"waitCount\":2},{\"name\":\"runTimeCollector\",\"id\":20,\"state\":\"TIMED_WAITING\",\"waitCount\":2},{\"name\":\"threadCollector\",\"id\":22,\"state\":\"RUNNABLE\",\"waitCount\":1},{\"name\":\"FileHandlerLogFilesCleaner-1\",\"id\":24,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@20fcc417\"},{\"name\":\"RMI TCP Accept-0\",\"id\":25,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"RMI TCP Accept-82\",\"id\":26,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"RMI TCP Accept-0\",\"id\":27,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"NioBlockingSelector.BlockPoller-1\",\"id\":28,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"NioBlockingSelector.BlockPoller-2\",\"id\":29,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"ContainerBackgroundProcessor[StandardEngine[Catalina]]\",\"id\":30,\"state\":\"TIMED_WAITING\",\"waitCount\":1},{\"name\":\"http-nio-8080-exec-1\",\"id\":31,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-2\",\"id\":32,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-3\",\"id\":33,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-4\",\"id\":34,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-5\",\"id\":35,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-6\",\"id\":36,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-7\",\"id\":37,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-8\",\"id\":38,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-9\",\"id\":39,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-exec-10\",\"id\":40,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@4a47c115\"},{\"name\":\"http-nio-8080-ClientPoller-0\",\"id\":41,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"http-nio-8080-Acceptor-0\",\"id\":42,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"http-nio-8080-AsyncTimeout\",\"id\":43,\"state\":\"TIMED_WAITING\",\"waitCount\":7},{\"name\":\"ajp-nio-8009-exec-1\",\"id\":44,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-2\",\"id\":45,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-3\",\"id\":46,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-4\",\"id\":47,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-5\",\"id\":48,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-6\",\"id\":49,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-7\",\"id\":50,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-8\",\"id\":51,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-9\",\"id\":52,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-exec-10\",\"id\":53,\"state\":\"WAITING\",\"waitCount\":1,\"lockName\":\"java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject@e363d4a\"},{\"name\":\"ajp-nio-8009-ClientPoller-0\",\"id\":54,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"ajp-nio-8009-Acceptor-0\",\"id\":55,\"state\":\"RUNNABLE\",\"waitCount\":0},{\"name\":\"ajp-nio-8009-AsyncTimeout\",\"id\":56,\"state\":\"TIMED_WAITING\",\"waitCount\":7}],\"overallInfo\":{\"TotalStartedThreadCount\":46,\"PeakThreadCount\":45,\"DaemonThreadCount\":44}}");

        Map<String, JSONObject> jsonObjectMap = jsonParser.getParsedMap(splited[0], splited[1]);
        assertEquals(threadInfoWorker.insertCollectionInfo(jsonObjectMap), true);
    }
}