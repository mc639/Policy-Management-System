
package PMS_Webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "update_password", namespace = "http://PMS_Webservice/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "update_password", namespace = "http://PMS_Webservice/", propOrder = {
    "id",
    "op",
    "np"
})
public class Update_password {

    @XmlElement(name = "id", namespace = "")
    private String id;
    @XmlElement(name = "op", namespace = "")
    private String op;
    @XmlElement(name = "np", namespace = "")
    private String np;

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

    /**
     * 
     * @return
     *     returns String
     */
    public String getOp() {
        return this.op;
    }

    /**
     * 
     * @param op
     *     the value for the op property
     */
    public void setOp(String op) {
        this.op = op;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getNp() {
        return this.np;
    }

    /**
     * 
     * @param np
     *     the value for the np property
     */
    public void setNp(String np) {
        this.np = np;
    }

}
