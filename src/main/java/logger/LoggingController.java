package logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingController {
    private static Logger logger;
    private static FileHandler fileHandler;

    static {
        try {
             /*
            [ Logger Setting ]
            window: D:\OJT_projects\logfile\collectserverlog\server.log
            linux: /home/junmokang/scriptBox/serverlog/server.log
            * */
            fileHandler = new FileHandler("D:\\OJT_projects\\logfile\\collectserverlog\\server.log", true);
            logger = Logger.getLogger(LoggingController.class.getName());
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setEncoding("UTF-8");
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            ErrorLoggingController.errorLogging(e);
        }
    }

    public static void logging(Level level, String msg) {
        logger.log(level, msg + "\n");
    }
}
