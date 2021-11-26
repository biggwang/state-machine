package com.biggwang.state.listener;

import com.biggwang.state.enity.UserStateEntity;
import com.biggwang.state.repository.UserStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

@Component
public class EntityStateListener implements PersistStateMachineHandler.PersistStateChangeListener {

    @Autowired
    private UserStateRepository userStateRepository;

    @Override
    public void onPersist(
            State<String, String> state,
            Message<String> message,
            Transition<String, String> transition,
            StateMachine<String, String> stateMachine) {

        if (message != null && message.getHeaders().containsKey("userState")) {
            Long id = message.getHeaders().get("userState", Long.class);
            UserStateEntity entity = userStateRepository.findById(id).orElseThrow(() -> new IllegalStateException());
            entity.setState(state.getId());
            userStateRepository.save(entity);
        }
    }
}
