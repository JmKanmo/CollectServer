package dao;

import config.JsonKey;
import dao.worker.ClassLoadingInfoWorker;
import dao.worker.HeapMemoryInfoWorker;
import dao.worker.RunTimeInfoWorker;
import dao.worker.ThreadInfoWorker;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

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
        DaoController daoController = Mockito.mock(DaoController.class);
        Mockito.when(daoController.workCollectionInfoInsertion(new HeapMemoryInfoWorker(daoController.getConnection()), null)).thenReturn(true);
        Mockito.when(daoController.invokeCollectionInfoWorker(JsonKey.HEAP_MEMORY_COLLECTOR, null)).thenReturn(true);
        assertEquals(daoController.invokeCollectionInfoWorker(JsonKey.HEAP_MEMORY_COLLECTOR, null), true);
        Mockito.verify(daoController, Mockito.times(1)).workCollectionInfoInsertion(new HeapMemoryInfoWorker(daoController.getConnection()), null);
    }
}