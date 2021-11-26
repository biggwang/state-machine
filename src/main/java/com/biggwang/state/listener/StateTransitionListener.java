package com.biggwang.state.listener;

import org.springframework.statemachine.ExtendedState;
import org.springframework.statemachine.annotation.EventHeaders;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

import java.util.Map;

@WithStateMachine(name = "biggwang")
public class StateTransitionListener {

    @OnTransition(source = "SI", target = "S1")
    public void t1(@EventHeaders Map<String, Object> headers, ExtendedState extendedState) {
        System.out.println("################### t1");
    }

    @OnTransition(source = "S1", target = "S3")
    public void t2(@EventHeaders Map<String, Object> headers, ExtendedState extendedState) {
        System.out.println("################### t2");
    }

    @OnTransition(source = "SI", target = "S3")
    public void t3(@EventHeaders Map<String, Object> headers, ExtendedState extendedState) {
        System.out.println("################### t3");
    }

}
