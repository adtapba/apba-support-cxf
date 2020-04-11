package es.apba.infra.esb.support.cxf.provider.mapper;

import es.apba.infra.esb.support.cxf.message.ExceptionMessageProvider;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.apache.cxf.interceptor.security.AuthenticationException;

/**
 * JAX-RS exception mapper for authentication ones
 * 
 * @author fsaucedo
 */
@Provider
public class AuthenticationExceptionMapper implements ExceptionMapper<AuthenticationException> {

    private final ExceptionMessageProvider exceptionMessageProvider;

    /**
     * Parametrized constructor
     * 
     * @param exceptionMessageProvider Exception message provider that returns a message applying the required format
     */
    public AuthenticationExceptionMapper(ExceptionMessageProvider exceptionMessageProvider) {
        this.exceptionMessageProvider = exceptionMessageProvider;
    }

    /**
     * Returns a response containing a 401 HTTP code and a formated message 
     * 
     * @param ex Authentication exception
     * @return response containing a 401 HTTP code and a formated message
     */
    @Override
    public Response toResponse(AuthenticationException ex) {
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(exceptionMessageProvider.produceMessage(ex))
                .build();
    }

}
