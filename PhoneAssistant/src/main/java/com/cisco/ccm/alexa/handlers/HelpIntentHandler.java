package com.cisco.ccm.alexa.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

public class HelpIntentHandler implements RequestHandler {

    //@Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.HelpIntent"));
    }

    //@Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "You can say me to do Login or to do Logout or to call any number !";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Phone Assistant", speechText)
                .withReprompt(speechText)
                .build();
    }
}
