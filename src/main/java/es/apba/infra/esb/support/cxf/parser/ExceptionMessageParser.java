package es.apba.infra.esb.support.cxf.parser;

/**
 * Interface for parsers of exception messages
 * 
 * @author fsaucedo
 */
public interface ExceptionMessageParser {
    
    /**
     * Method that parses an exception message and returns the appropiate HTTP response code
     * 
     * @param exceptionMessage Exception message
     * @return HTTP response code
     */
    int getHttpResponseCode(String exceptionMessage);
    
}
