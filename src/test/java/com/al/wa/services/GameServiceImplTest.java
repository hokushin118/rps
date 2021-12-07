package com.al.wa.services;

import com.al.wa.enums.Hand;
import com.al.wa.enums.Player;
import com.al.wa.exceptions.RpsException;
import com.al.wa.model.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Testing GameServiceImpl class")
class GameServiceImplTest {
    private GameService gameService;

    @BeforeEach
    void setup() {
        this.gameService = new GameServiceImpl();
    }

    @Test
    @DisplayName("Testing welcomeMessage() method")
    void welcomeMessageTest() {
        assertEquals(GameServiceImpl.WELCOME_MESSAGE, this.gameService.welcomeMessage());
    }

    @Test
    @DisplayName("Testing enterOptionsMessage() method")
    void enterOptionsMessageTest() {
        assertEquals(GameServiceImpl.HAND_FIGURE, this.gameService.enterOptionsMessage());
    }

    @Test
    @DisplayName("Testing pickUserChoice() method")
    void pickUserChoiceTest() {
        assertDoesNotThrow(() -> this.gameService.pickUserChoice(Hand.ROCK));
        assertDoesNotThrow(() -> this.gameService.pickUserChoice(Hand.PAPER));
        assertDoesNotThrow(() -> this.gameService.pickUserChoice(Hand.SCISSORS));

        assertThrows(RpsException.class, () -> this.gameService.pickUserChoice(Hand.EMPTY));
    }

    @Test
    @DisplayName("Testing pickMachineChoice() method")
    void pickMachineChoiceTest() {
        final var hand = this.gameService.pickMachineChoice();

        assertNotNull(hand);
        assertInstanceOf(Hand.class, hand);
    }

    @Test
    @DisplayName("Testing updateChain() method with Rock")
    void updateChainTest() {
        assertDoesNotThrow(() -> this.gameService.updateChain(Hand.ROCK));
        assertDoesNotThrow(() -> this.gameService.updateChain(Hand.PAPER));
        assertDoesNotThrow(() -> this.gameService.updateChain(Hand.SCISSORS));
    }

    @Test
    @DisplayName("Testing calculateResult() method")
    void calculateResultTest() {
        final var player = this.gameService.calculateResult();

        assertNotNull(player);
        assertInstanceOf(Player.class, player);
        assertEquals(Player.DRAW, player);
    }

    @Test
    @DisplayName("Testing calculateResult() method")
    void calculateResultWinUserTest() {
        Hand userChoice;
        final var machineChoice = this.gameService.pickMachineChoice();
        if (machineChoice == Hand.ROCK) {
            userChoice = Hand.PAPER;
        } else if (machineChoice == Hand.PAPER) {
            userChoice = Hand.SCISSORS;
        } else {
            userChoice = Hand.ROCK;
        }

        this.gameService.pickUserChoice(userChoice);
        final var player = this.gameService.calculateResult();

        assertNotNull(player);
        assertInstanceOf(Player.class, player);
        assertEquals(Player.USER, player);
    }

    @Test
    @DisplayName("Testing calculateResult() method")
    void calculateResultWinMachineTest() {
        Hand userChoice;
        final var machineChoice = this.gameService.pickMachineChoice();
        if (machineChoice == Hand.ROCK) {
            userChoice = Hand.SCISSORS;
        } else if (machineChoice == Hand.PAPER) {
            userChoice = Hand.ROCK;
        } else {
            userChoice = Hand.PAPER;
        }

        this.gameService.pickUserChoice(userChoice);
        final var player = this.gameService.calculateResult();

        assertNotNull(player);
        assertInstanceOf(Player.class, player);
        assertEquals(Player.MACHINE, player);
    }

    @Test
    @DisplayName("Testing getResults() method")
    void getResultsTest() {
        final var score = this.gameService.getResults();

        assertNotNull(score);
        assertInstanceOf(Score.class, score);
    }
}