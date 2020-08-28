package dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class DaoControllerTest {
    @Test
    public void testInit() {
        DaoController daoController = new DaoController();
        daoController.init();
        assertNotNull(daoController.getConnection());
    }
}