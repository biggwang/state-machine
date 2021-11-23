package com.biggwang.state.code;

import java.util.Arrays;

public enum StatesEnum {
    LOCKED, UNLOCKED;

    public static StatesEnum getEnum(String state) {
        return Arrays.stream(StatesEnum.values())
                .filter(item -> item.name().equals(state))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
