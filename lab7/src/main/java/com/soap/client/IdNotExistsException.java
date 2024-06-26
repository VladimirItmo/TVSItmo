
package com.soap.client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "IdNotExistsException", targetNamespace = "http://soap.com/")
public class IdNotExistsException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private IdNotExistsFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public IdNotExistsException(String message, IdNotExistsFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public IdNotExistsException(String message, IdNotExistsFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.soap.client.IdNotExistsFault
     */
    public IdNotExistsFault getFaultInfo() {
        return faultInfo;
    }

}
