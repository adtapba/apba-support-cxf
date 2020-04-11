package es.apba.infra.esb.support.cxf.message;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tester for JsonExceptionMessageProvider
 * 
 * @author fsaucedo
 */
public class JsonExceptionMessageProviderTest {
    
    JsonExceptionMessageProvider instance;

    public JsonExceptionMessageProviderTest() {
        instance = new JsonExceptionMessageProvider();
    }
    
    @Test
    public void whenTextMessage_thenProducesJsonMessage() {
        Exception ex = mock(Exception.class);
        when(ex.getMessage()).thenReturn("test message");
        
        assertEquals("Wrong JSON message", 
                "{\"error\":\"test message\"}",
                instance.produceMessage(ex));
    }
    
    @Test
    public void whenTextMessageContainingDoubleQuotes_thenProducesJsonMessage() {
        Exception ex = mock(Exception.class);
        when(ex.getMessage()).thenReturn("\"test message\"");
        
        assertEquals("Wrong JSON message", 
                "{\"error\":\"test message\"}",
                instance.produceMessage(ex));
    }
    
}
