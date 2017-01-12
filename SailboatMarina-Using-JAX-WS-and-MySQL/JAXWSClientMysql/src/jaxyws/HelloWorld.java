
package jaxyws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloWorld", targetNamespace = "http://jaxyws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloWorld {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "helloWorld", targetNamespace = "http://jaxyws/", className = "jaxyws.HelloWorld_Type")
    @ResponseWrapper(localName = "helloWorldResponse", targetNamespace = "http://jaxyws/", className = "jaxyws.HelloWorldResponse")
    @Action(input = "http://jaxyws/HelloWorld/helloWorldRequest", output = "http://jaxyws/HelloWorld/helloWorldResponse")
    public String helloWorld(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
