package dao;

import config.JsonKey;
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

    }
}