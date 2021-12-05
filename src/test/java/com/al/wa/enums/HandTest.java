package com.al.wa.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.al.wa.enums.Hand.EMPTY;
import static com.al.wa.enums.Hand.PAPER;
import static com.al.wa.enums.Hand.ROCK;
import static com.al.wa.enums.Hand.SCISSORS;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Hand enum")
class HandTest {
    private static final int TOTAL_ITEMS = 4;

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
