package com.biggwang.state.repository;

import com.biggwang.state.code.StatesEnum;
import com.biggwang.state.enity.UserStateEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
@Transactional
class UserStateRepositoryTest {

    @Autowired
    private UserStateRepository userStateRepository;

    @Test
    void selectTest() {
        Iterable<UserStateEntity> list = userStateRepository.findAll();
        assertThat(list, is(notNullValue()));
    }

    @Test
    @Rollback(value = false)
    void saveTest() {
        UserStateEntity userStateEntity = userStateRepository.save(
                UserStateEntity.builder()
                        .state(StatesEnum.LOCKED.toString())
                        .build()
        );
        assertThat(userStateEntity.getId(), is(notNullValue()));
    }
}