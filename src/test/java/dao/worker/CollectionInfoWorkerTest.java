package dao.worker;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.*;

public class CollectionInfoWorkerTest {
    @Test
    public void testGetNullOrNot() {
        JSONObject jsonObject = Mockito.mock(JSONObject.class);
        Mockito.when(jsonObject.get(Mockito.anyString())).thenReturn(null);
        CollectionInfoWorker collectionInfoWorker = new ThreadInfoWorker(null);

        String strLet = collectionInfoWorker.getNullOrNot((String) jsonObject.get("ddd"));
        assertEquals(strLet, "undefined");

        Long longRet = collectionInfoWorker.getNullOrNot((Long) jsonObject.get("ddd"));
        assertEquals(longRet.longValue(), 0L);

        Integer integerRet = collectionInfoWorker.getNullOrNot((Integer) jsonObject.get("ddd"));
        assertEquals(longRet.intValue(), 0);
    }
}