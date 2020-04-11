package es.apba.infra.esb.support.cxf.provider.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import es.apba.infra.esb.support.cxf.message.ExceptionMessageProvider;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * JAX-RS exception mapper for JSON processing ones
 * 
 * @author fsaucedo
 */
@Provider
public class JsonProcessingExceptionMapper implements ExceptionMapper<JsonProcessingException> {

    private final ExceptionMessageProvider exceptionMessageProvider;

    /**
     * Parametrized constructor
     * 
     * @param exceptionMessageProvider Exception message provider that returns a message applying the required format
     */
    public JsonProcessingExceptionMapper(ExceptionMessageProvider exceptionMessageProvider) {
        this.exceptionMessageProvider = exceptionMessageProvider;
    }

    /**
     * Returns a response containing a 400 HTTP code and a formated message 
     * 
     * @param ex Access denied exception
     * @return response containing a 400 HTTP code and a formated message
     */
    @Override
    public Response toResponse(JsonProcessingException ex) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(exceptionMessageProvider.produceMessage(ex))
                .build();
    }

}
