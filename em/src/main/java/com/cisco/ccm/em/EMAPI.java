package com.cisco.ccm.em;

 import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/* Sample Java code snippet for using the EM API's */

public class EMAPI
{
    static APIConfig oAPIConfig = null;
    /* This method reads the XML string for the EM API */
    public String getXMLStr()
    {
        String  sTemp = "";
        String sRes = "";   
        String sFileName = oAPIConfig.FILENAME; 
        try
        {
            FileReader ofr = new FileReader(sFileName);
            BufferedReader obf= new BufferedReader(ofr);
            while (( sTemp = obf.readLine()) != null)
                sRes += sTemp+"\n";
        }  
        catch(Exception e) 
        {
               System.out.println("Error reading file :" + e.getMessage());
        }    
        return sRes;
    }   
    /* This method posts the http request using the EMService API */
    public  String postMsg(String strXML) throws IOException
    {		
            String sName = URLEncoder.encode("xml");
            String sValue = URLEncoder.encode(strXML);
            String sQuery = (sName + "=" + sValue);
            URL myURL =  new URL("http://nasinha-lnx:8080/emservice/EMServiceServlet");		
            HttpURLConnection connection = (HttpURLConnection)myURL.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            PrintWriter out = null;
            try
            {
                    out = new PrintWriter(connection.getOutputStream());
                    out.println(sQuery);
            }
            catch (Exception ex )	
            {
                    ex.printStackTrace();
            }
            finally	
            {
                    out.close();
            }
            /* Read the response for the request send */
            BufferedReader b = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String retStr = "";
            String line = b.readLine();
            while ( line != null )
            {
                    retStr += line;
                    line = b.readLine();			
            }			
            return retStr;
    }
    public String getEMLoginXMLString(String userid , String deviceName , String deviceProfile) {
    	
    	StringBuffer response = new StringBuffer();
    	response.append("<request><appInfo><appID>ccmadmin</appID><appCertificate>cisco_infy</appCertificate></appInfo><login><deviceName>");
    	response.append(deviceName);
    	response.append("</deviceName><userID>");
    	response.append(userid);
    	response.append("</userID><deviceProfile>");
    	response.append(deviceProfile);
    	response.append("</deviceProfile></login></request>");
    			
    	
    	return response.toString();
    }

    public String getEMLogoutXMLString(String userid , String deviceName) {
    	
    	StringBuffer response = new StringBuffer();
    	response.append("<request><appInfo><appID>ccmadmin</appID><appCertificate>cisco_infy</appCertificate></appInfo><logout><deviceName>");
    	response.append(deviceName);
    	response.append("</deviceName><userID>");
    	response.append(userid);
    	response.append("</userID>");	
    	response.append("</logout></request>");
    			
    	
    	return response.toString();
    }
    
    public static void main(String[] args)
    {
        EMAPI oEMAPI = new EMAPI();
        oAPIConfig = new APIConfig();
        String sXML=oEMAPI.getXMLStr();
        try
        {
            System.out.println(oEMAPI.postMsg(sXML));
        }
        catch(Exception oExc) 
        {
            System.out.println("Exception:" + oExc);
        }
    }
}