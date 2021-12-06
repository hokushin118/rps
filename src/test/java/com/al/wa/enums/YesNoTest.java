package com.al.wa.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static com.al.wa.enums.YesNo.NO;
import static com.al.wa.enums.YesNo.YES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("Testing YesNo enum")
class YesNoTest {
    private static final int TOTAL_ITEMS = 2;

    @Test
    @DisplayName("Testing valueOfCode() method")
    void valueOfCodeTest() {
        Stream.of(YesNo.values()).forEach(item -> assertSame(item, YesNo.valueOfCode(item.getCode())));
    }

    @Test
    @DisplayName("Testing toString() method")
    void toStringTest() {
        assertEquals("Y", YesNo.YES.toString());
        assertEquals("N", YesNo.NO.toString());
    }

    @Test
    @DisplayName("Testing getCode() method")
    void getCodeTest() {
        assertEquals("Y", YesNo.YES.getCode());
        assertEquals("N", YesNo.NO.getCode());
    }

    @Test
    @DisplayName("Testing values() method")
    void valuesTest() {
        assertEquals(TOTAL_ITEMS, YesNo.values().length);
    }

    @Test
    @DisplayName("Testing valueOf() method")
    void valueOfTest() {
        assertEquals(YES, YesNo.valueOf("YES"));
        assertEquals(NO, YesNo.valueOf("NO"));
    }
}
