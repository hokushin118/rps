package com.al.wa.helpers;

import com.al.wa.enums.Hand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.al.wa.enums.Hand.ROCK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testing MarkovChain class")
class MarkovChainInteractionsTest {
    @Mock
    private MarkovChain markovChain;

    @Test
    @DisplayName("Testing nextMove() method")
    void nextMoveTest() {
        final var hand = ROCK;
        when(this.markovChain.nextMove(anyFloat())).thenReturn(hand);

        final var receivedHand = this.markovChain.nextMove(9.2f);

        assertNotNull(receivedHand);
        assertEquals(hand, receivedHand);

        verify(this.markovChain, times(1)).nextMove(anyFloat());
        verifyNoMoreInteractions(this.markovChain);
        reset(this.markovChain);
    }

    @Test
    @DisplayName("Testing updateChain() method")
    void updateChainTest() {
        doNothing().when(this.markovChain).updateChain(any(Hand.class));

        this.markovChain.updateChain(ROCK);

        verify(this.markovChain, times(1)).updateChain(any(Hand.class));
        verifyNoMoreInteractions(this.markovChain);
        reset(this.markovChain);
    }
}
