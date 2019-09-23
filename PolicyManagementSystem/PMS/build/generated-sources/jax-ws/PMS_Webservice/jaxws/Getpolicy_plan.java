
package PMS_Webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getpolicy_plan", namespace = "http://PMS_Webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getpolicy_plan", namespace = "http://PMS_Webservice/")
public class Getpolicy_plan {

    @XmlElement(name = "id", namespace = "")
    private String id;

    /**
     * 
     * @return
     *     returns String
     */
    public String getId() {
        return this.id;
    }

    /**
     * 
     * @param id
     *     the value for the id property
     */
    public void setId(String id) {
        this.id = id;
    }

}
