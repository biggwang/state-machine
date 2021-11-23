//package com.biggwang.state.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.statemachine.config.EnableStateMachine;
//import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
//import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
//import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
//
//@Configuration
//@EnableStateMachine
//public class StateMachineConfig extends StateMachineConfigurerAdapter<String, String> {
//
//    @Override
//    public void configure(StateMachineStateConfigurer<String, String> states) throws Exception {
//        states.withStates()
//                .initial("UNLOCK")
//                .state("LOCK");
//    }
//
//    @Override
//    public void configure(StateMachineTransitionConfigurer<String, String> transitions) throws Exception {
//        transitions
//                .withExternal()
//                    .source("LOCK").target("UNLOCK")
//                    .event("OPEN")
//                    .and()
//                .withExternal()
//                    .source("UNLOCK").target("LOCK")
//                    .event("CLOSE");
//    }
//
//}
