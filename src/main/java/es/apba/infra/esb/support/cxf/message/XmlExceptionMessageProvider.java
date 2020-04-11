package es.apba.infra.esb.support.cxf.message;

/**
 * XML exception message provider
 * 
 * @author fsaucedo
 */
public class XmlExceptionMessageProvider implements ExceptionMessageProvider {

    /**
     * Produces an exception message applying XML format
     * 
     * @param ex Exception
     * @return Exception message
     */
    @Override
    public String produceMessage(Exception ex) {
        return "<error>" + ex.getMessage().replaceAll("\"", "") + "</error>";
    }
    
}
