package com.al.wa.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.al.wa.enums.Hand.EMPTY;
import static com.al.wa.enums.Hand.PAPER;
import static com.al.wa.enums.Hand.ROCK;
import static com.al.wa.enums.Hand.SCISSORS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Testing Hand enum")
class HandTest {
    private static final int TOTAL_ITEMS = 4;

    @ParameterizedTest
    @EnumSource(Hand.class)
    @DisplayName("Testing valueOfInt() method")
    void valueOfCodeTest(Hand hand) {
        assertSame(hand, Hand.valueOfInt(hand.getId()));
    }

    @Test
    @DisplayName("Testing valueOf() method")
    void valueOfTest() {
        assertEquals(ROCK, Hand.valueOf("ROCK"));
        assertEquals(PAPER, Hand.valueOf("PAPER"));
        assertEquals(SCISSORS, Hand.valueOf("SCISSORS"));
        assertEquals(EMPTY, Hand.valueOf("EMPTY"));
    }

    @Test
    @DisplayName("Testing isWinBy() method")
    void isWinByTest() {
        assertTrue(ROCK.isWinBy(PAPER));
        assertTrue(PAPER.isWinBy(SCISSORS));
        assertTrue(SCISSORS.isWinBy(ROCK));

        assertFalse(ROCK.isWinBy(SCISSORS));
        assertFalse(SCISSORS.isWinBy(PAPER));
        assertFalse(PAPER.isWinBy(ROCK));
    }

    @Test
    @DisplayName("Testing values() method")
    void valuesTest() {
        assertEquals(TOTAL_ITEMS, Hand.values().length);
    }

    @Test
    @DisplayName("Testing of() method")
    void valueOfIntTest() {
        assertEquals(ROCK, Hand.valueOfInt(1));
        assertEquals(PAPER, Hand.valueOfInt(2));
        assertEquals(SCISSORS, Hand.valueOfInt(3));
        assertEquals(EMPTY, Hand.valueOfInt(4));
    }
}
