package com.biggwang.state.config;

import com.biggwang.state.code.EventEnum;
import com.biggwang.state.code.StatesEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends StateMachineConfigurerAdapter<String, String> {

    @Override
    public void configure(StateMachineStateConfigurer<String, String> states) throws Exception {
        states.withStates()
                .initial(StatesEnum.UNLOCKED.name())
                .state(StatesEnum.LOCKED.name());
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<String, String> transitions) throws Exception {
        transitions
                .withExternal()
                    .source(StatesEnum.LOCKED.name()).target(StatesEnum.UNLOCKED.name())
                    .event(EventEnum.OPEN.name())
                    .and()
                .withExternal()
                    .source(StatesEnum.UNLOCKED.name()).target(StatesEnum.LOCKED.name())
                    .event(EventEnum.CLOSE.name());
    }

}
