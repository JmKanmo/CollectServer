package logger;

import org.junit.Test;

import java.sql.SQLException;
import java.util.logging.Level;

import static org.junit.Assert.*;

public class LoggingControllerTest {

    @Test
    public void logging() {
        LoggingController.logging(Level.INFO,"hello world");
    }
}