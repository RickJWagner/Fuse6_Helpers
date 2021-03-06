package org.sample;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.12.redhat-1
 * 2018-11-07T13:33:32.330-06:00
 * Generated source version: 3.1.12.redhat-1
 * 
 */
@WebServiceClient(name = "PaymentService", 
                  wsdlLocation = "file:/home/rick/Tools/A/Fuse7.1/jboss-eap-7.1.0/jboss-eap-7.1/quickstarts/camel/A_camel-cxf-jaxws-jms/src/main/resources/wsdl/transfer.wsdl",
                  targetNamespace = "http://ws.sample.org/payment-service") 
public class PaymentService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.sample.org/payment-service", "PaymentService");
    public final static QName PaymentPort = new QName("http://ws.sample.org/payment-service", "PaymentPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/home/rick/Tools/A/Fuse7.1/jboss-eap-7.1.0/jboss-eap-7.1/quickstarts/camel/A_camel-cxf-jaxws-jms/src/main/resources/wsdl/transfer.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PaymentService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/home/rick/Tools/A/Fuse7.1/jboss-eap-7.1.0/jboss-eap-7.1/quickstarts/camel/A_camel-cxf-jaxws-jms/src/main/resources/wsdl/transfer.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PaymentService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PaymentService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PaymentService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public PaymentService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public PaymentService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public PaymentService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns Payment
     */
    @WebEndpoint(name = "PaymentPort")
    public Payment getPaymentPort() {
        return super.getPort(PaymentPort, Payment.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Payment
     */
    @WebEndpoint(name = "PaymentPort")
    public Payment getPaymentPort(WebServiceFeature... features) {
        return super.getPort(PaymentPort, Payment.class, features);
    }

}
