package es.apba.infra.esb.support.cxf.provider.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.apba.infra.esb.support.cxf.message.ExceptionMessageProvider;
import javax.ws.rs.core.Response;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tester for JsonProcessingExceptionMapper
 * 
 * @author fsaucedo
 */
public class JsonProcessingExceptionMapperTest {
   
    JsonProcessingExceptionMapper instance;
    JsonProcessingException ex;

    public JsonProcessingExceptionMapperTest() {
        ex = mock(JsonProcessingException.class);
        when(ex.getMessage()).thenReturn("test message");

        String message = ex.getMessage();
        ExceptionMessageProvider exceptionMessageProvider = mock(ExceptionMessageProvider.class);
        when(exceptionMessageProvider.produceMessage(ex)).thenReturn("<error>" + message + "</error>");

        instance = new JsonProcessingExceptionMapper(exceptionMessageProvider);
    }

    @Test
    public void whenAuthenticationException_then400HttpResponseAndAFormatedMessage() {
        Response response = instance.toResponse(ex);
        
        assertEquals("Wrong HTTP code", 400, response.getStatus());
        assertEquals("Wrong message", "<error>test message</error>", response.getEntity());
    }    
    
}
