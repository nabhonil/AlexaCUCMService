package com.cisco.ccm.alexa;

import com.cisco.ccm.alexa.utils.Constants;
import com.cisco.ccm.alexa.utils.HttpHelper;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			HttpHelper hp = new HttpHelper();
			hp.sendPOST(Constants.BASE_URL + Constants.CALL_URL);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
