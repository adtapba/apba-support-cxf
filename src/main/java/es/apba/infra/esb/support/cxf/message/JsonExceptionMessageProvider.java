package es.apba.infra.esb.support.cxf.message;

/**
 * JSON exception message provider
 * 
 * @author fsaucedo
 */
public class JsonExceptionMessageProvider implements ExceptionMessageProvider {

    /**
     * Produces an exception message applying JSON format
     * 
     * @param ex Exception
     * @return Exception message
     */
    @Override
    public String produceMessage(Exception ex) {
        return "{\"error\":\"" + ex.getMessage().replaceAll("\"", "") + "\"}";
    }
    
}
