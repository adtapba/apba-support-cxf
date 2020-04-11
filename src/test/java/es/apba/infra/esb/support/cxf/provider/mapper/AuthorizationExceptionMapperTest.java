package es.apba.infra.esb.support.cxf.provider.mapper;

import es.apba.infra.esb.support.cxf.message.ExceptionMessageProvider;
import javax.ws.rs.core.Response;
import org.apache.cxf.interceptor.security.AccessDeniedException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tester for AuthorizationExceptionMapper
 * 
 * @author fsaucedo
 */
public class AuthorizationExceptionMapperTest {
    
    AuthorizationExceptionMapper instance;
    AccessDeniedException ex;

    public AuthorizationExceptionMapperTest() {
        ex = mock(AccessDeniedException.class);
        when(ex.getMessage()).thenReturn("test message");

        String message = ex.getMessage();
        ExceptionMessageProvider exceptionMessageProvider = mock(ExceptionMessageProvider.class);
        when(exceptionMessageProvider.produceMessage(ex)).thenReturn("<error>" + message + "</error>");
        
        instance = new AuthorizationExceptionMapper(exceptionMessageProvider);
    }
    
    @Test
    public void whenAuthenticationException_then403HttpResponseAndAFormatedMessage() {
        Response response = instance.toResponse(ex);
        
        assertEquals("Wrong HTTP code", 403, response.getStatus());
        assertEquals("Wrong message", "<error>test message</error>", response.getEntity());
    }
    
}
