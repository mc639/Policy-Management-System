package com.example.zeel01.pms_app;

/**
 * Created by ZEEL 01 on 3/9/2017.
 */


import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class W_GetWishlist {

    private static String METHOD_NAME = "getwishlist";
    private static String NAMESPACE = "http://PMS_Webservice/";
    private static String SOAP_ACTION = NAMESPACE + METHOD_NAME;
    // http://localhost:8080/WebApplication8/DemoService?WSDL
    // private static final String
    // URL="http://192.168.42.128:8080/webApplication8/DemoService/hello?wsdl";
    private static String URL = "http://192.168.43.63:8080/PMS/PMSWebservice?WSDL";

    public static String get(String id) {
        String str="";
        try {
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            request.addProperty("id", id);
            // editext_user_name.getText().toString());
            // request.addProperty("arg[1]",
            // editext_password.getText().toString());
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);


            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION, envelope);
            Object result = envelope.getResponse();
            str= result.toString();
            Log.i("Ankit", str);

        } catch (Exception e) {
            Log.i("error in image", "image upload error");
        }
        return str;
    }

}
