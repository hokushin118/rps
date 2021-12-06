package com.al.wa.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum YesNo {
    YES("Y"),
    NO("N");

    private static final Map<String, YesNo> BY_CODE = new HashMap<>();

    private final String code;

    static {
        Stream.of(values()).forEach(item -> BY_CODE.put(item.code, item));
    }

    public static YesNo valueOfCode(String code) {
        return BY_CODE.get(code);
    }

    @Override
    public String toString() {
        return this.code;
    }
}
