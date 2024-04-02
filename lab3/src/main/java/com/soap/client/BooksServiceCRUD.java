
package com.soap.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BooksServiceCRUD", targetNamespace = "http://soap.com/", wsdlLocation = "http://0.0.0.0:8080/BooksServiceCRUD?wsdl")
public class BooksServiceCRUD
    extends Service
{

    private final static URL BOOKSSERVICECRUD_WSDL_LOCATION;
    private final static WebServiceException BOOKSSERVICECRUD_EXCEPTION;
    private final static QName BOOKSSERVICECRUD_QNAME = new QName("http://soap.com/", "BooksServiceCRUD");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://0.0.0.0:8080/BooksServiceCRUD?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BOOKSSERVICECRUD_WSDL_LOCATION = url;
        BOOKSSERVICECRUD_EXCEPTION = e;
    }

    public BooksServiceCRUD() {
        super(__getWsdlLocation(), BOOKSSERVICECRUD_QNAME);
    }

    public BooksServiceCRUD(WebServiceFeature... features) {
        super(__getWsdlLocation(), BOOKSSERVICECRUD_QNAME, features);
    }

    public BooksServiceCRUD(URL wsdlLocation) {
        super(wsdlLocation, BOOKSSERVICECRUD_QNAME);
    }

    public BooksServiceCRUD(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BOOKSSERVICECRUD_QNAME, features);
    }

    public BooksServiceCRUD(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BooksServiceCRUD(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BooksWebService
     */
    @WebEndpoint(name = "BooksWebServicePort")
    public BooksWebService getBooksWebServicePort() {
        return super.getPort(new QName("http://soap.com/", "BooksWebServicePort"), BooksWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BooksWebService
     */
    @WebEndpoint(name = "BooksWebServicePort")
    public BooksWebService getBooksWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap.com/", "BooksWebServicePort"), BooksWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BOOKSSERVICECRUD_EXCEPTION!= null) {
            throw BOOKSSERVICECRUD_EXCEPTION;
        }
        return BOOKSSERVICECRUD_WSDL_LOCATION;
    }

}