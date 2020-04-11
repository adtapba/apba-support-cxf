package es.apba.infra.esb.support.cxf.message;

/**
 * Interface for an exception message provider
 * 
 * @author fsaucedo
 */
public interface ExceptionMessageProvider {

    /**
     * Produces an exception message applying the required format
     * 
     * @param ex Exception
     * @return Exception message
     */
    String produceMessage(Exception ex);

}
