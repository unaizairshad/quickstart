
package com.training;

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
@WebServiceClient(name = "NumberToTextService", targetNamespace = "http://service.training.com/", wsdlLocation = "http://localhost:7070/number?wsdl")
public class NumberToTextService_Service
    extends Service
{

    private final static URL NUMBERTOTEXTSERVICE_WSDL_LOCATION;
    private final static WebServiceException NUMBERTOTEXTSERVICE_EXCEPTION;
    private final static QName NUMBERTOTEXTSERVICE_QNAME = new QName("http://service.training.com/", "NumberToTextService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:7070/number?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NUMBERTOTEXTSERVICE_WSDL_LOCATION = url;
        NUMBERTOTEXTSERVICE_EXCEPTION = e;
    }

    public NumberToTextService_Service() {
        super(__getWsdlLocation(), NUMBERTOTEXTSERVICE_QNAME);
    }

    public NumberToTextService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), NUMBERTOTEXTSERVICE_QNAME, features);
    }

    public NumberToTextService_Service(URL wsdlLocation) {
        super(wsdlLocation, NUMBERTOTEXTSERVICE_QNAME);
    }

    public NumberToTextService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NUMBERTOTEXTSERVICE_QNAME, features);
    }

    public NumberToTextService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NumberToTextService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns NumberToTextService
     */
    @WebEndpoint(name = "NumberToTextPort")
    public NumberToTextService getNumberToTextPort() {
        return super.getPort(new QName("http://service.training.com/", "NumberToTextPort"), NumberToTextService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NumberToTextService
     */
    @WebEndpoint(name = "NumberToTextPort")
    public NumberToTextService getNumberToTextPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.training.com/", "NumberToTextPort"), NumberToTextService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NUMBERTOTEXTSERVICE_EXCEPTION!= null) {
            throw NUMBERTOTEXTSERVICE_EXCEPTION;
        }
        return NUMBERTOTEXTSERVICE_WSDL_LOCATION;
    }

}
