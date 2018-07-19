package com.cisco.ccm.em;

public class APIConfig
{
	/* Change the parameters in the file */
	
	/* Replace SERVERNAME with the IP Address of the Call Manager */
    public final String SERVERNAME = "nasinha-lnx";
    
    /* Replace URLSTR with the correct URL based on the version of the Call Manager */
    /* For 4.x use http://<SERVERNAME>/emservice/EMServiceServlet */
    /* For 5.x, 6.x and 7.x use http://<SERVERNAME>:8080/emservice/EMServiceServlet */    
    public final String URLSTR = "http://"+ SERVERNAME+ ":8080/emservice/EMServiceServlet";
    
    /* Replace OPERATION with either login, logout, logoutAll, userquery or devicequery */
    public final String OPERATION = "logoutAll";
    
    /* Replace FILENAME with the complete path of the xml file */
    public final String FILENAME = "./" + OPERATION + ".xml";
    
    
}