package com.cisco.ccm.alexa.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;
import com.cisco.ccm.alexa.utils.Constants;
import com.cisco.ccm.alexa.utils.HttpHelper;

import java.util.Optional;

public class EmLoginIntentHandler implements RequestHandler {

    //@Override
    public boolean canHandle(HandlerInput input) {
       return input.matches(Predicates.intentName("EmLoginIntent"));
    }

   // @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Initiating extension mobility login";
        try {
        	HttpHelper hp = new HttpHelper();
        	hp.sendPOST(Constants.BASE_URL + Constants.EMLOGIN_URL);
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Phone Assistant", speechText)
                .build();
    }

}
