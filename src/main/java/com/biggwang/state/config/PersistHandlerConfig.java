package com.biggwang.state.config;

import com.biggwang.state.listener.EntityStateListener;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;

@Configuration
@RequiredArgsConstructor
public class PersistHandlerConfig {

    private final StateMachine<String, String> stateMachine;
    private final EntityStateListener entityStateListener;

    @Bean
    public PersistStateMachineHandler persistStateMachineHandler() {
        PersistStateMachineHandler handler = new PersistStateMachineHandler(stateMachine);
        handler.addPersistStateChangeListener(entityStateListener);
        return handler;
    }
}
