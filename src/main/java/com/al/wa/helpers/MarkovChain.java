package com.al.wa.helpers;

import com.al.wa.enums.Hand;

import static com.al.wa.enums.Hand.PAPER;
import static com.al.wa.enums.Hand.ROCK;
import static com.al.wa.enums.Hand.SCISSORS;

/**
 * This class contains Markov Chain Algorithm functionality.
 */
public class MarkovChain {
    private static final int HAND_LENGTH = 3;

    // Markov Chain for the AI of machine player (stores probabilities)
    private final float[][] markovChain;
    private final int[] timesPlayed;

    // Last move of human player
    private int lastMove;
    // Second to last move of human player
    private int penultimateMove;

    public MarkovChain() {
        this.markovChain = new float[][]{
                {0.33f, 0.33f, 0.33f},
                {0.33f, 0.33f, 0.33f},
                {0.33f, 0.33f, 0.33f}};
        this.timesPlayed = new int[]{0, 0, 0};
    }

    /**
     * Predicts the human player's next move and make move according the prediction.
     *
     * @param randomFloat random float value
     * @return machine move
     */
    public Hand nextMove(float randomFloat) {
        if (randomFloat <= this.markovChain[this.lastMove][1]) {
            return PAPER;
        } else if (randomFloat <= this.markovChain[this.lastMove][2] + this.markovChain[this.lastMove][1]) {
            return SCISSORS;
        }
        return ROCK;
    }

    /**
     * Updates Markov chain with results of the last game.
     *
     * @param userChoice human player input from last game
     */
    public void updateChain(Hand userChoice) {
        this.penultimateMove = this.lastMove;
        if (userChoice == ROCK) {
            this.lastMove = 0;
        } else if (userChoice == PAPER) {
            this.lastMove = 1;
        } else {
            this.lastMove = 2;
        }
        // Multiply everything in the appropriate column of the Markov Chain by timesPlayed[penultimateMove]
        for (var i = 0; i < HAND_LENGTH; i++) {
            this.markovChain[this.penultimateMove][i] *= this.timesPlayed[this.penultimateMove];
        }
        // Increment the appropriate row value by one
        this.markovChain[this.penultimateMove][this.lastMove] += 1;
        // Increment timesPlayed[penultimateMove] by one
        this.timesPlayed[this.penultimateMove]++;
        // Divide all values in Markov Chain by timesPlayed[penultimateMove] value
        for (var j = 0; j < HAND_LENGTH; j++) {
            this.markovChain[this.penultimateMove][j] /= this.timesPlayed[this.penultimateMove];
        }
    }
}
