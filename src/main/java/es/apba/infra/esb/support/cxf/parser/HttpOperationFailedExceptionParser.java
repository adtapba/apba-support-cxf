package es.apba.infra.esb.support.cxf.parser;

/**
 * Parser for org.apache.camel.component.http4.HttpOperationFailedException exception messages
 * 
 * @author fsaucedo
 */
public class HttpOperationFailedExceptionParser implements ExceptionMessageParser {

    private static final int DEFAULT_HTTP_RESPONSE_CODE = 500;
    private static final String SEARCHED_STRING = "statusCode:";

    /**
     * Method that parses an exception message and returns the appropiate HTTP response code
     * 
     * @param exceptionMessage Exception message
     * @return HTTP response code
     */
    @Override
    public int getHttpResponseCode(String exceptionMessage) {
        int httpResponseCode = DEFAULT_HTTP_RESPONSE_CODE;

        if (exceptionMessage != null && !exceptionMessage.trim().equals("")) {
            int startingIndexOfTheCode = exceptionMessage.lastIndexOf(SEARCHED_STRING);
            if (startingIndexOfTheCode != -1) {
                String stringHttpResponseCode
                        = exceptionMessage.substring(startingIndexOfTheCode + SEARCHED_STRING.length()).trim();

                if (isInteger(stringHttpResponseCode)) {
                    httpResponseCode = Integer.parseInt(stringHttpResponseCode);
                }
            }
        }

        return httpResponseCode;
    }

    /**
     * Method that figures out if a String is a proper integer or not
     * 
     * @param str Input string
     * @return Is an integer?
     */
    boolean isInteger(String str) {
        if (str == null) {
            return false;
        } else if (str.equals("")) {
            return false;
        } else {
            return str.matches("\\d+");
        }
    }
    
}
