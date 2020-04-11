package es.apba.infra.esb.support.cxf.provider.mapper;

import es.apba.infra.esb.support.cxf.message.ExceptionMessageProvider;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.apache.cxf.interceptor.security.AccessDeniedException;

/**
 * JAX-RS exception mapper for authorization ones
 * 
 * @author fsaucedo
 */
@Provider
public class AuthorizationExceptionMapper implements ExceptionMapper<AccessDeniedException> {

    private final ExceptionMessageProvider exceptionMessageProvider;

    /**
     * Parametrized constructor
     * 
     * @param exceptionMessageProvider Exception message provider that returns a message applying the required format
     */
    public AuthorizationExceptionMapper(ExceptionMessageProvider exceptionMessageProvider) {
        this.exceptionMessageProvider = exceptionMessageProvider;
    }

    /**
     * Returns a response containing a 403 HTTP code and a formated message 
     * 
     * @param ex Access denied exception
     * @return response containing a 403 HTTP code and a formated message
     */
    @Override
    public Response toResponse(AccessDeniedException ex) {
        return Response.status(Response.Status.FORBIDDEN)
                .entity(exceptionMessageProvider.produceMessage(ex))
                .build();
    }

}
