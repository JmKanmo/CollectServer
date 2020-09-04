package handler;

import config.JsonKey;
import dao.DaoController;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.*;
import parser.JsonParser;

public class CollectionInfoHandlerTest {
    @InjectMocks
    CollectionInfoHandler collectionInfoHandler;

    @Mock
    JsonParser jsonParser;

    @Mock
    DaoController daoController;

    @Test
    public void addCollectionInfo() throws ParseException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(jsonParser.getParsedMap(Mockito.anyString())).thenReturn(null);

        Mockito.when(daoController.invokeCollectionInfoWorker(JsonKey.THREAD_COLLECTOR, null)).thenReturn(true);
        Mockito.when(daoController.invokeCollectionInfoWorker(JsonKey.RUNTIME_COLLECTOR, null)).thenReturn(true);
        Mockito.when(daoController.invokeCollectionInfoWorker(JsonKey.HEAP_MEMORY_COLLECTOR, null)).thenReturn(true);
        Mockito.when(daoController.invokeCollectionInfoWorker(JsonKey.CLASS_LOADING_COLLECTOR, null)).thenReturn(true);

        Assert.assertEquals(collectionInfoHandler.addCollectionInfo(JsonKey.THREAD_COLLECTOR, ""), true);
        Assert.assertEquals(collectionInfoHandler.addCollectionInfo(JsonKey.CLASS_LOADING_COLLECTOR, ""), true);
        Assert.assertEquals(collectionInfoHandler.addCollectionInfo(JsonKey.RUNTIME_COLLECTOR, ""), true);
        Assert.assertEquals(collectionInfoHandler.addCollectionInfo(JsonKey.HEAP_MEMORY_COLLECTOR, ""), true);

        Mockito.verify(jsonParser, Mockito.times(4)).getParsedMap(Mockito.anyString());

        Mockito.verify(daoController, Mockito.times(1)).invokeCollectionInfoWorker(JsonKey.THREAD_COLLECTOR, null);
        Mockito.verify(daoController, Mockito.times(1)).invokeCollectionInfoWorker(JsonKey.CLASS_LOADING_COLLECTOR, null);
        Mockito.verify(daoController, Mockito.times(1)).invokeCollectionInfoWorker(JsonKey.RUNTIME_COLLECTOR, null);
        Mockito.verify(daoController, Mockito.times(1)).invokeCollectionInfoWorker(JsonKey.HEAP_MEMORY_COLLECTOR, null);
    }
}