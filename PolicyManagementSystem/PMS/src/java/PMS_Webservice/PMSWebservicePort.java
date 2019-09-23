/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PMS_Webservice;

import PMS_Webservice_client.PMSWebservice;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author ZEEL 01
 */
@Path("pmswebserviceport")
public class PMSWebservicePort {

    private PMSWebservice port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PMSWebservicePort
     */
    public PMSWebservicePort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method checklogin
     * @param l resource URI parameter
     * @param p resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("checklogin/")
    public String getChecklogin(@QueryParam("l") String l, @QueryParam("p") String p) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.checklogin(l, p);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method getpolicy_plan
     * @param id resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("getpolicy_plan/")
    public String getpolicyPlan(@QueryParam("id") String id) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.getpolicyPlan(id);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method hello
     * @param name resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("hello/")
    public String getHello(@QueryParam("name") String name) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.hello(name);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method getpolicy
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("getpolicy/")
    public String getpolicy() {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.getpolicy();
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     * Invokes the SOAP method update_password
     * @param id resource URI parameter
     * @param op resource URI parameter
     * @param np resource URI parameter
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    @Path("update_password/")
    public String getUpdatePassword(@QueryParam("id") String id, @QueryParam("op") String op, @QueryParam("np") String np) {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.lang.String result = port.updatePassword(id, op, np);
                return result;
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private PMSWebservice getPort() {
        try {
            // Call Web Service Operation
            PMS_Webservice_client.PMSWebservice_Service service = new PMS_Webservice_client.PMSWebservice_Service();
            PMS_Webservice_client.PMSWebservice p = service.getPMSWebservicePort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
