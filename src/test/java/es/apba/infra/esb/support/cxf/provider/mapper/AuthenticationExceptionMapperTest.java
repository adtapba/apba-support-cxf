package es.apba.infra.esb.support.cxf.provider.mapper;

import es.apba.infra.esb.support.cxf.message.ExceptionMessageProvider;
import javax.ws.rs.core.Response;
import org.apache.cxf.interceptor.security.AuthenticationException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tester for AuthenticationExceptionMapper
 *
 * @author fsaucedo
 */
public class AuthenticationExceptionMapperTest {

    AuthenticationExceptionMapper instance;
    AuthenticationException ex;

    public AuthenticationExceptionMapperTest() {
        ex = mock(AuthenticationException.class);
        when(ex.getMessage()).thenReturn("test message");

        String message = ex.getMessage();
        ExceptionMessageProvider exceptionMessageProvider = mock(ExceptionMessageProvider.class);
        when(exceptionMessageProvider.produceMessage(ex)).thenReturn("<error>" + message + "</error>");

        instance = new AuthenticationExceptionMapper(exceptionMessageProvider);
    }

    @Test
    public void whenAuthenticationException_then401HttpResponseAndAFormatedMessage() {
        Response response = instance.toResponse(ex);
        
        assertEquals("Wrong HTTP code", 401, response.getStatus());
        assertEquals("Wrong message", "<error>test message</error>", response.getEntity());
    }

}
