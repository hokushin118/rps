package com.al.wa.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Score class")
class ScoreTest {
    private Score score;

    @BeforeEach
    void setup(){
        this.score = new Score();
    }

    @Test
    @DisplayName("Testing incrementGamesWonByUser() method")
    void incrementGamesWonByUserTest() {
        assertDoesNotThrow(()->this.score.incrementGamesWonByUser());
    }

    @Test
    @DisplayName("Testing incrementTotalGames() method")
    void incrementTotalGamesTest() {
        assertDoesNotThrow(()->this.score.incrementTotalGames());
    }

    @Test
    @DisplayName("Testing getGamesWonByUser() method")
    void getGamesWonByUserTest() {
        this.score.incrementGamesWonByUser();
        assertEquals(1, score.getGamesWonByUser());
    }

    @Test
    @DisplayName("Testing getTotalGames() method")
    void getTotalGamesTest() {
        this.score.incrementTotalGames();
        assertEquals(1, score.getTotalGames());
    }
}
