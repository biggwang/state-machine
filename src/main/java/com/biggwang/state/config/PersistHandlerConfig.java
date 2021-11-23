//package com.biggwang.state.config;
//
//import com.biggwang.state.Persist;
//import com.biggwang.state.repository.UserStateRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.statemachine.StateMachine;
//import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
//
//@Configuration
//public class PersistHandlerConfig {
//
//    @Autowired
//    private StateMachine<String, String> stateMachine;
//
//    @Autowired
//    private UserStateRepository userStateRepository;
//
//    @Bean
//    public Persist persist() {
//        return new Persist(persistStateMachineHandler(), userStateRepository);
//    }
//
//    @Bean
//    public PersistStateMachineHandler persistStateMachineHandler() {
//        return new PersistStateMachineHandler(stateMachine);
//    }
//}
