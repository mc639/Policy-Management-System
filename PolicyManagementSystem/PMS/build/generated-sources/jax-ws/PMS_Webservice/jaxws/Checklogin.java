
package PMS_Webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "checklogin", namespace = "http://PMS_Webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checklogin", namespace = "http://PMS_Webservice/", propOrder = {
    "l",
    "p"
})
public class Checklogin {

    @XmlElement(name = "l", namespace = "")
    private String l;
    @XmlElement(name = "p", namespace = "")
    private String p;

    /**
     * 
     * @return
     *     returns String
     */
    public String getL() {
        return this.l;
    }

    /**
     * 
     * @param l
     *     the value for the l property
     */
    public void setL(String l) {
        this.l = l;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getP() {
        return this.p;
    }

    /**
     * 
     * @param p
     *     the value for the p property
     */
    public void setP(String p) {
        this.p = p;
    }

}
