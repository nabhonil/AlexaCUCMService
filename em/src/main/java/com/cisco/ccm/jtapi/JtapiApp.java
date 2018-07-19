package com.cisco.ccm.jtapi;

import javax.telephony.Address;
import javax.telephony.Call;
import javax.telephony.CallObserver;
import javax.telephony.Provider;
import javax.telephony.ProviderObserver;
import javax.telephony.events.CallEv;
import javax.telephony.events.ProvEv;
import javax.telephony.events.ProvInServiceEv;

import com.cisco.cti.util.Condition;


public class JtapiApp {

	private static final String ip_address = "10.105.38.235";
	private static final String userid = "user1";
	private static final String passwrd = "cisco";

	public void call(String dn) {

		ProviderService.validate_login(ip_address, userid, passwrd);

		try {
			System.out.println("provider opening");
			Provider provider = ProviderService.getProvider();
			if (provider == null)
				return;
			System.out.println("provider opened");
			final Condition inService = new Condition();
            provider.addObserver(new ProviderObserver() {
                public void providerChangedEvent(ProvEv[] eventList) {
                    if (eventList == null) {
                        return;
                    }
                    for (int i = 0; i < eventList.length; ++i) {
                        if (eventList[i] instanceof ProvInServiceEv) {
                            inService.set();
                        }
                    }
                }
            });
            inService.waitTrue();
			
          
			Address[] addresses = provider.getAddresses();
			Address address1 = addresses[0];
			Address address2 = addresses[1];
			
			CallObserver co = new CallObserver() {
				@Override
				public void callChangedEvent(CallEv[] arg0) {
					// TODO Auto-generated method stub
				}
            };
			address1.addCallObserver(co);
			address2.addCallObserver(co);
			
			System.out.println("Calling : " + address1.getName() + " --> " + address2.getName());
			Call call = provider.createCall();
			call.connect(address1.getTerminals()[0], address1, address2.getName());
			System.out.println("Done making call");

		} catch (Exception e) {
			// Log
			System.err.println("Exception throws: " + e.getMessage());
		}
	}

}