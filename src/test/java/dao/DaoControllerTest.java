package dao;

import config.JsonKey;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class DaoControllerTest {
    @Test
    public void testInit() {
        DaoController daoController = new DaoController();
        assertNotNull(daoController.getConnection());
    }

    @Test
    public void testInvokeCollectionInfoWorker() {
        DaoController daoController = new DaoController();
        assertEquals(daoController.invokeCollectionInfoWorker(JsonKey.CLASS_LOADING_COLLECTOR, Collections.emptyMap()), true);
        assertEquals(daoController.invokeCollectionInfoWorker(JsonKey.HEAP_MEMORY_COLLECTOR, Collections.emptyMap()), true);
        assertEquals(daoController.invokeCollectionInfoWorker(JsonKey.RUNTIME_COLLECTOR, Collections.emptyMap()), true);
        assertEquals(daoController.invokeCollectionInfoWorker(JsonKey.THREAD_COLLECTOR, Collections.emptyMap()), true);
    }
}