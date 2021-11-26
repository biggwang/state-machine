package com.biggwang.state.config;

import com.biggwang.state.code.Events;
import com.biggwang.state.code.States;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;

import java.util.Arrays;
import java.util.stream.Collectors;

@Configuration
@EnableStateMachine(name = "biggwang")
public class StateMachineConfig extends StateMachineConfigurerAdapter<String, String> {

    @Override
    public void configure(StateMachineStateConfigurer<String, String> states) throws Exception {
        states
            .withStates()
                .initial(States.SI.toString())
                .choice(States.S1.toString())
                .end(States.SF.toString())
                .states(Arrays.stream(States.values()).map(item -> item.toString()).collect(Collectors.toSet()));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<String, String> transitions) throws Exception {
        transitions
            .withExternal()
                .source(States.SI.toString())
                .target(States.S1.toString())
                .event(Events.E1.toString())
                .and()
            .withChoice()
                .source(States.S1.toString())
                .first(States.S2.toString(), s2Guard())
                .then(States.S3.toString(), s3Guard())
                .last(States.S4.toString());

    }

    @Bean
    public Guard<String, String> s2Guard() {
        return context -> {
            System.out.println("s2Guard는 false 되었습니다.");
            return false;
        };
    }

    @Bean
    public Guard<String, String> s3Guard() {
        return context -> {
            System.out.println("s3Guard는 true 되었습니다.");
            return true;
        };
    }

}
