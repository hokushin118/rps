package com.al.wa.services;

import com.al.wa.enums.Hand;
import com.al.wa.model.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.al.wa.enums.Hand.ROCK;
import static com.al.wa.enums.Player.USER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testing GameServiceImpl class")
class GameServiceInteractionsTest {
    @Mock
    private GameService gameService;

    @Test
    @DisplayName("Testing welcomeMessage() method")
    void welcomeMessageTest() {
        when(this.gameService.welcomeMessage()).thenReturn(GameServiceImpl.WELCOME_MESSAGE);

        final var welcomeMessage = this.gameService.welcomeMessage();

        assertNotNull(welcomeMessage);
        assertEquals(GameServiceImpl.WELCOME_MESSAGE, welcomeMessage);

        verify(this.gameService).welcomeMessage();
        verifyNoMoreInteractions(this.gameService);
        reset(this.gameService);
    }

    @Test
    @DisplayName("Testing enterOptionsMessage() method")
    void enterOptionsMessageTest() {
        when(this.gameService.enterOptionsMessage()).thenReturn(GameServiceImpl.HAND_FIGURE);

        final var enterOptionsMessage = this.gameService.enterOptionsMessage();

        assertNotNull(enterOptionsMessage);
        assertEquals(GameServiceImpl.HAND_FIGURE, enterOptionsMessage);

        verify(this.gameService).enterOptionsMessage();
        verifyNoMoreInteractions(this.gameService);
        reset(this.gameService);
    }

    @Test
    @DisplayName("Testing pickUserChoice() method")
    void pickUserChoiceTest() {
        doNothing().when(this.gameService).pickUserChoice(any(Hand.class));

        this.gameService.pickUserChoice(ROCK);

        verify(this.gameService).pickUserChoice(any(Hand.class));
        verifyNoMoreInteractions(this.gameService);
        reset(this.gameService);
    }

    @Test
    @DisplayName("Testing pickMachineChoice() method")
    void pickMachineChoiceTest() {
        final var hand = ROCK;
        when(this.gameService.pickMachineChoice()).thenReturn(hand);

        final var receivedHand = this.gameService.pickMachineChoice();

        assertNotNull(receivedHand);
        assertEquals(hand, receivedHand);

        verify(this.gameService).pickMachineChoice();
        verifyNoMoreInteractions(this.gameService);
        reset(this.gameService);
    }

    @Test
    @DisplayName("Testing calculateResult() method")
    void calculateResultTest() {
        final var player = USER;
        when(this.gameService.calculateResult()).thenReturn(player);

        final var receivedPlayer = this.gameService.calculateResult();

        assertNotNull(receivedPlayer);
        assertEquals(player, receivedPlayer);

        verify(this.gameService).calculateResult();
        verifyNoMoreInteractions(this.gameService);
        reset(this.gameService);
    }

    @Test
    @DisplayName("Testing getResults() method")
    void getResultsTest() {
        final var score = new Score();
        when(this.gameService.getResults()).thenReturn(score);

        final var receivedScore = this.gameService.getResults();

        assertNotNull(receivedScore);
        assertEquals(score, receivedScore);

        verify(this.gameService).getResults();
        verifyNoMoreInteractions(this.gameService);
        reset(this.gameService);
    }
}
