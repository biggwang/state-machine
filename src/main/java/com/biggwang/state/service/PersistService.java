package com.biggwang.state.service;

import com.biggwang.state.enity.UserStateEntity;
import com.biggwang.state.repository.UserStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersistService {

    private final UserStateRepository userStateRepository;
    private final PersistStateMachineHandler handler;

    public void change(Long id, String event) {
        UserStateEntity entity = userStateRepository.findById(id).orElseThrow(() -> new IllegalStateException());
        handler.handleEventWithStateReactively(MessageBuilder
                        .withPayload(event).setHeader("userState", entity.getId()).build(), entity.getState())
                .subscribe();
    }
}
