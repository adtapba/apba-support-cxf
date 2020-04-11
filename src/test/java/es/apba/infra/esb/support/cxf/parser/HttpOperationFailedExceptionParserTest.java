package es.apba.infra.esb.support.cxf.parser;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tester for HttpOperationFailedExceptionParser 
 * 
 * @author fsaucedo
 */
public class HttpOperationFailedExceptionParserTest {
    
    HttpOperationFailedExceptionParser instance;
    
    public HttpOperationFailedExceptionParserTest() {
        instance = new HttpOperationFailedExceptionParser();
    }

    @Test
    public void whenExpectedMessageFormat_thenGetHttpResponseCodeReturnTheParsedCode() {
        assertEquals("Wrong response code found", 
                404, 
                instance.getHttpResponseCode("HTTP operation failed invoking http://localhost:8080/pbamsgsys/rest/evtmsg with statusCode: 404"));
    }

    @Test
    public void whenMessageIsNull_thenGetHttpResponseCodeReturnInternalServerErrorCode() {
        assertEquals("Wrong response code found", 500, instance.getHttpResponseCode(null));
    }

    @Test
    public void whenMessageIsEmpty_thenGetHttpResponseCodeReturnInternalServerErrorCode() {
        assertEquals("Wrong response code found", 500, instance.getHttpResponseCode(" "));
    }

    @Test
    public void whenInteger_thenIsIntegerReturnTrue() {
        assertEquals("It should be and Integer", true, instance.isInteger("1234"));
    }
    
    @Test
    public void whenInputHasALetter_thenIsIntegerReturnFalse() {
        assertEquals("It shouldn't be and Integer", false, instance.isInteger("1a234"));
    }
    
    @Test
    public void whenInputHasASpecialCharacter_thenIsIntegerReturnFalse() {
        assertEquals("It shouldn't be and Integer", false, instance.isInteger("1_234"));
    }
    
    @Test
    public void whenInputIsNull_thenIsIntegerReturnFalse() {
        assertEquals("It shouldn't be and Integer", false, instance.isInteger(null));
    }
    
    @Test
    public void whenInputIsEmpty_thenIsIntegerReturnFalse() {
        assertEquals("It shouldn't be and Integer", false, instance.isInteger(" "));
    }
    
}
