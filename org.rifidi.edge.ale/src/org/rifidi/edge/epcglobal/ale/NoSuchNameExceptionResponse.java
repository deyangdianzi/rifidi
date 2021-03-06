
package org.rifidi.edge.epcglobal.ale;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.4
 * 2015-12-12T14:01:05.528-05:00
 * Generated source version: 3.1.4
 */

@WebFault(name = "NoSuchNameException", targetNamespace = "urn:epcglobal:ale:wsdl:1")
public class NoSuchNameExceptionResponse extends Exception {
    
    private org.rifidi.edge.epcglobal.ale.NoSuchNameException noSuchNameException;

    public NoSuchNameExceptionResponse() {
        super();
    }
    
    public NoSuchNameExceptionResponse(String message) {
        super(message);
    }
    
    public NoSuchNameExceptionResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchNameExceptionResponse(String message, org.rifidi.edge.epcglobal.ale.NoSuchNameException noSuchNameException) {
        super(message);
        this.noSuchNameException = noSuchNameException;
    }

    public NoSuchNameExceptionResponse(String message, org.rifidi.edge.epcglobal.ale.NoSuchNameException noSuchNameException, Throwable cause) {
        super(message, cause);
        this.noSuchNameException = noSuchNameException;
    }

    public org.rifidi.edge.epcglobal.ale.NoSuchNameException getFaultInfo() {
        return this.noSuchNameException;
    }
}
