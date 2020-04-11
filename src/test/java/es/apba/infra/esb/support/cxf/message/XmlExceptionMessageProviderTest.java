package es.apba.infra.esb.support.cxf.message;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tester for XmlExceptionMessageProvider
 * 
 * @author fsaucedo
 */
public class XmlExceptionMessageProviderTest {
    
    XmlExceptionMessageProvider instance;

    public XmlExceptionMessageProviderTest() {
        instance = new XmlExceptionMessageProvider();
    }
    
    @Test
    public void whenTextMessage_thenProducesXmlMessage() {
        Exception ex = mock(Exception.class);
        when(ex.getMessage()).thenReturn("test message");
        
        assertEquals("Wrong XML message", 
                "<error>test message</error>",
                instance.produceMessage(ex));
    }
    
    @Test
    public void whenTextMessageContainingDoubleQuotes_thenProducesXmlMessage() {
        Exception ex = mock(Exception.class);
        when(ex.getMessage()).thenReturn("\"test message\"");
        
        assertEquals("Wrong XML message", 
                "<error>test message</error>",
                instance.produceMessage(ex));
    }
    
}
