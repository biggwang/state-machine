package com.biggwang.state.controller;

import com.biggwang.state.Persist;
import com.biggwang.state.code.EventEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TriggerController {

    private final Persist persist;

    @GetMapping("/close/{id}")
    public String publishClose(@PathVariable Long id) {
        persist.change(id, EventEnum.CLOSE.name());
        return "closed!";
    }

    @GetMapping("/open/{id}")
    public String publishOpen(@PathVariable Long id) {
        persist.change(id, EventEnum.OPEN.name());
        return "opened!";
    }
}
