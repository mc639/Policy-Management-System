
package PMS_Webservice_client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the PMS_Webservice_client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Checklogin_QNAME = new QName("http://PMS_Webservice/", "checklogin");
    private final static QName _CheckloginResponse_QNAME = new QName("http://PMS_Webservice/", "checkloginResponse");
    private final static QName _Getpolicy_QNAME = new QName("http://PMS_Webservice/", "getpolicy");
    private final static QName _GetpolicyResponse_QNAME = new QName("http://PMS_Webservice/", "getpolicyResponse");
    private final static QName _GetpolicyPlan_QNAME = new QName("http://PMS_Webservice/", "getpolicy_plan");
    private final static QName _GetpolicyPlanResponse_QNAME = new QName("http://PMS_Webservice/", "getpolicy_planResponse");
    private final static QName _Hello_QNAME = new QName("http://PMS_Webservice/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://PMS_Webservice/", "helloResponse");
    private final static QName _UpdatePassword_QNAME = new QName("http://PMS_Webservice/", "update_password");
    private final static QName _UpdatePasswordResponse_QNAME = new QName("http://PMS_Webservice/", "update_passwordResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: PMS_Webservice_client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Checklogin }
     * 
     */
    public Checklogin createChecklogin() {
        return new Checklogin();
    }

    /**
     * Create an instance of {@link CheckloginResponse }
     * 
     */
    public CheckloginResponse createCheckloginResponse() {
        return new CheckloginResponse();
    }

    /**
     * Create an instance of {@link Getpolicy }
     * 
     */
    public Getpolicy createGetpolicy() {
        return new Getpolicy();
    }

    /**
     * Create an instance of {@link GetpolicyResponse }
     * 
     */
    public GetpolicyResponse createGetpolicyResponse() {
        return new GetpolicyResponse();
    }

    /**
     * Create an instance of {@link GetpolicyPlan }
     * 
     */
    public GetpolicyPlan createGetpolicyPlan() {
        return new GetpolicyPlan();
    }

    /**
     * Create an instance of {@link GetpolicyPlanResponse }
     * 
     */
    public GetpolicyPlanResponse createGetpolicyPlanResponse() {
        return new GetpolicyPlanResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link UpdatePassword }
     * 
     */
    public UpdatePassword createUpdatePassword() {
        return new UpdatePassword();
    }

    /**
     * Create an instance of {@link UpdatePasswordResponse }
     * 
     */
    public UpdatePasswordResponse createUpdatePasswordResponse() {
        return new UpdatePasswordResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Checklogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PMS_Webservice/", name = "checklogin")
    public JAXBElement<Checklogin> createChecklogin(Checklogin value) {
        return new JAXBElement<Checklogin>(_Checklogin_QNAME, Checklogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckloginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PMS_Webservice/", name = "checkloginResponse")
    public JAXBElement<CheckloginResponse> createCheckloginResponse(CheckloginResponse value) {
        return new JAXBElement<CheckloginResponse>(_CheckloginResponse_QNAME, CheckloginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Getpolicy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PMS_Webservice/", name = "getpolicy")
    public JAXBElement<Getpolicy> createGetpolicy(Getpolicy value) {
        return new JAXBElement<Getpolicy>(_Getpolicy_QNAME, Getpolicy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetpolicyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PMS_Webservice/", name = "getpolicyResponse")
    public JAXBElement<GetpolicyResponse> createGetpolicyResponse(GetpolicyResponse value) {
        return new JAXBElement<GetpolicyResponse>(_GetpolicyResponse_QNAME, GetpolicyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetpolicyPlan }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PMS_Webservice/", name = "getpolicy_plan")
    public JAXBElement<GetpolicyPlan> createGetpolicyPlan(GetpolicyPlan value) {
        return new JAXBElement<GetpolicyPlan>(_GetpolicyPlan_QNAME, GetpolicyPlan.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetpolicyPlanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PMS_Webservice/", name = "getpolicy_planResponse")
    public JAXBElement<GetpolicyPlanResponse> createGetpolicyPlanResponse(GetpolicyPlanResponse value) {
        return new JAXBElement<GetpolicyPlanResponse>(_GetpolicyPlanResponse_QNAME, GetpolicyPlanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PMS_Webservice/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PMS_Webservice/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePassword }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PMS_Webservice/", name = "update_password")
    public JAXBElement<UpdatePassword> createUpdatePassword(UpdatePassword value) {
        return new JAXBElement<UpdatePassword>(_UpdatePassword_QNAME, UpdatePassword.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePasswordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://PMS_Webservice/", name = "update_passwordResponse")
    public JAXBElement<UpdatePasswordResponse> createUpdatePasswordResponse(UpdatePasswordResponse value) {
        return new JAXBElement<UpdatePasswordResponse>(_UpdatePasswordResponse_QNAME, UpdatePasswordResponse.class, null, value);
    }

}
