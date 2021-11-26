package com.biggwang.state.controller;

import com.biggwang.state.code.StatesEnum;
import com.biggwang.state.enity.UserStateEntity;
import com.biggwang.state.repository.UserStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequiredArgsConstructor
public class SampleController {

    private final UserStateRepository userStateRepository;

    @GetMapping("/init/{event}")
    public String init(@PathVariable String event) {
        UserStateEntity userStateEntity = userStateRepository.save(
                UserStateEntity.builder()
                        .state(event)
                        .build()
        );
        return userStateEntity.toString();
    }

    @GetMapping("/list")
    public List getList() {
        return StreamSupport
                .stream(userStateRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
