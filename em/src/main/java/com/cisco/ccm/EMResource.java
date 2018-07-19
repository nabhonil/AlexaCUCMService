
package com.cisco.ccm;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.cisco.ccm.em.APIConfig;
import com.cisco.ccm.em.EMAPI;
import com.cisco.ccm.jtapi.JtapiApp;

@Path("alexa")
public class EMResource {

	static APIConfig oAPIConfig = null;
	
    @POST
    @Path("call/{dn}")
    @Produces("text/plain")
    public String emCall(@PathParam("dn")  String dn) {
    	System.out.println(dn);
    	new JtapiApp().call(dn);
        return "Dialled Number is "+dn;
    }

    @POST
    @Path("emlogin/{userid}/{deviceName}/{deviceProfile}")
    @Produces("text/plain")
    public String emLogin(@PathParam("userid")  String userid,@PathParam("deviceName")  String deviceName,@PathParam("deviceProfile")  String deviceProfile) {
    	System.out.println(userid+" "+deviceName+"" + deviceProfile);
    	  EMAPI oEMAPI = new EMAPI();
          oAPIConfig = new APIConfig();
          String sXML=oEMAPI.getEMLoginXMLString(userid, deviceName, deviceProfile);
          System.out.println(sXML);
          try
          {
              System.out.println(oEMAPI.postMsg(sXML));
          }
          catch(Exception oExc) 
          {	
        	  oExc.printStackTrace();
              System.out.println("Exception:" + oExc);
          }
        return "EMLogin for "+userid;
    }

    @POST
    @Path("emlogout/{userid}/{deviceName}")
    @Produces("text/plain")
    public String emLogout(@PathParam("userid")  String userid,@PathParam("deviceName")  String deviceName) {
    	System.out.println(userid+" "+deviceName+"" );
    	  EMAPI oEMAPI = new EMAPI();
          oAPIConfig = new APIConfig();
          String sXML=oEMAPI.getEMLogoutXMLString(userid, deviceName);
          System.out.println(sXML);
          try
          {
              System.out.println(oEMAPI.postMsg(sXML));
          }
          catch(Exception oExc) 
          {
        	  oExc.printStackTrace();
              System.out.println("Exception:" + oExc);
          }
        return "EM Logout for "+userid;
    }

}
