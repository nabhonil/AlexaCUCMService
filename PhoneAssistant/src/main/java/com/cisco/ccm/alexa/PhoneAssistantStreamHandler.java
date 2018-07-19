package com.cisco.ccm.alexa;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;

import com.cisco.ccm.alexa.handlers.CancelandStopIntentHandler;
import com.cisco.ccm.alexa.handlers.EmLoginIntentHandler;
import com.cisco.ccm.alexa.handlers.EmLogoutIntentHandler;
import com.cisco.ccm.alexa.handlers.FallbackIntentHandler;
import com.cisco.ccm.alexa.handlers.PhoneAssistantIntentHandler;
import com.cisco.ccm.alexa.handlers.HelpIntentHandler;
import com.cisco.ccm.alexa.handlers.SessionEndedRequestHandler;
import com.cisco.ccm.alexa.handlers.LaunchRequestHandler;

 public class PhoneAssistantStreamHandler extends SkillStreamHandler {

     private static Skill getSkill() {
         return Skills.standard()
                 .addRequestHandlers(
                		 new CancelandStopIntentHandler(), 
                		 new PhoneAssistantIntentHandler(),
                		 new EmLoginIntentHandler(),
                		 new EmLogoutIntentHandler(),
                		 new HelpIntentHandler(), 
                		 new LaunchRequestHandler(), 
                		 new SessionEndedRequestHandler(),
                		 new FallbackIntentHandler())
                 .build();
     }

     public PhoneAssistantStreamHandler() {
         super(getSkill());
     }

 }
