//package com.biggwang.state;
//
//import com.biggwang.state.enity.UserStateEntity;
//import com.biggwang.state.repository.UserStateRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.statemachine.StateMachine;
//import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
//import org.springframework.statemachine.state.State;
//import org.springframework.statemachine.transition.Transition;
//import org.springframework.stereotype.Component;
//
////@Component
//public class Persist {
//
//    private final PersistStateMachineHandler handler;
////    @Autowired
//    private final UserStateRepository userStateRepository;
//    private final PersistStateMachineHandler.PersistStateChangeListener listener = new LocalPersistStateChangeListener();
//
//    public Persist(PersistStateMachineHandler handler, UserStateRepository userStateRepository) {
//        this.handler = handler;
//        this.handler.addPersistStateChangeListener(listener);
//        this.userStateRepository = userStateRepository;
//    }
//
//    public void change(Long id, String event) {
//        UserStateEntity entity = userStateRepository.findById(id).orElseThrow(() -> new IllegalStateException());
//        handler.handleEventWithStateReactively(MessageBuilder
//                        .withPayload(event).setHeader("userState", entity).build(), entity.getState())
//                .subscribe();
//    }
//
//    private class LocalPersistStateChangeListener implements PersistStateMachineHandler.PersistStateChangeListener {
//
//        @Override
//        public void onPersist(State<String, String> state, Message<String> message, Transition<String, String> transition, StateMachine<String, String> stateMachine) {
//            if (message != null && message.getHeaders().containsKey("userState")) {
//                Long id = message.getHeaders().get("userState", Long.class);
//                UserStateEntity entity = userStateRepository.findById(id).orElseThrow(() -> new IllegalStateException());
//                entity.setState(state.getId());
//                userStateRepository.save(entity);
//            }
//        }
//    }
//}