package com.al.wa.helpers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.al.wa.enums.Hand.PAPER;
import static com.al.wa.enums.Hand.ROCK;
import static com.al.wa.enums.Hand.SCISSORS;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing MarkovChain class")
class MarkovChainTest {

    @Test
    @DisplayName("Testing nextMove() method")
    void nextMoveTest() {
        final var markovChain = new MarkovChain();

        assertEquals(PAPER, markovChain.nextMove(rndFloat(0.0f, 0.33f)));
        assertEquals(SCISSORS, markovChain.nextMove(rndFloat(0.34f, 0.66f)));
        assertEquals(ROCK, markovChain.nextMove(rndFloat(0.67f, 1.0f)));
    }

    private static float rndFloat(float min, float max) {
        return new Random().nextFloat() * (max - min) + min;
    }
}