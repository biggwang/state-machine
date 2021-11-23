package com.biggwang.state;

import com.biggwang.state.code.EventEnum;
import com.biggwang.state.code.StatesEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.test.StateMachineTestPlan;
import org.springframework.statemachine.test.StateMachineTestPlanBuilder;

@SpringBootTest
public class StateMachineTest {

    @Autowired
    private StateMachine<StatesEnum, EventEnum> machine;

    @Test
    void stateMachineTest() throws Exception {
        StateMachineTestPlan<StatesEnum, EventEnum> stateMachineTestPlan =
                StateMachineTestPlanBuilder.<StatesEnum, EventEnum>builder()
                        .defaultAwaitTime(2)
                        .stateMachine(machine)
                        .step()
                        .sendEvent(EventEnum.OPEN).expectStateEntered(StatesEnum.UNLOCKED)
                        .sendEvent(EventEnum.CLOSE).expectStateEntered(StatesEnum.LOCKED)
                        .and()
                        .build();
        stateMachineTestPlan.test();
    }

}
