package com.cisco.ccm.alexa.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpHelper {
	
	public void sendPOST(String sURL) throws IOException {
		URL obj = new URL(sURL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", Constants.USER_AGENT);

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST request not worked. Response Code: " + responseCode);
		}
	}

}
