package com.cisco.ccm.alexa.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.display.BodyTemplate6;
import com.amazon.ask.model.interfaces.display.Image;
import com.amazon.ask.model.interfaces.display.ImageInstance;
import com.amazon.ask.model.interfaces.display.RichText;
import com.amazon.ask.model.interfaces.display.Template;
import com.amazon.ask.model.interfaces.display.TextContent;
import com.amazon.ask.request.Predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LaunchRequestHandler implements RequestHandler {

     //@Override
     public boolean canHandle(HandlerInput input) {
         return input.matches(Predicates.requestType(LaunchRequest.class));
     }

     //@Override
     public Optional<Response> handle(HandlerInput input) {
         String speechText = "Welcome to the Alexa Phone Assistant Skill, You can say me to do Login or to do Logout or to call any number !";
         return input.getResponseBuilder()
                 .withSpeech(speechText)
                 .withSimpleCard("Phone Assistant", speechText)
                 .withReprompt(speechText)
                 .build();
     }
}