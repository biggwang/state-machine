package com.biggwang.state.controller;

import com.biggwang.state.code.EventEnum;
import com.biggwang.state.service.PersistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TriggerController {

    private final PersistService persistService;

    @GetMapping("/{id}/{event}")
    public String trigger(@PathVariable Long id, @PathVariable String event) {
        persistService.change(id, event);
        return "triggered!";
    }

    @GetMapping("/close/{id}")
    public String publishClose(@PathVariable Long id) {
        persistService.change(id, EventEnum.CLOSE.name());
        return "closed!";
    }

    @GetMapping("/open/{id}")
    public String publishOpen(@PathVariable Long id) {
        persistService.change(id, EventEnum.OPEN.name());
        return "opened!";
    }
}
