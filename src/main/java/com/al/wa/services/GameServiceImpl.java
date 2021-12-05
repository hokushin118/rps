package com.al.wa.services;

import com.al.wa.enums.Hand;
import com.al.wa.enums.Player;
import com.al.wa.exceptions.RpsException;
import com.al.wa.helpers.MarkovChain;
import com.al.wa.model.Score;

import java.util.concurrent.ThreadLocalRandom;

import static com.al.wa.enums.Hand.EMPTY;

/**
 * This class implements Rock Paper Scissor game functionality.
 */
public class GameServiceImpl implements GameService {
    static final String WELCOME_MESSAGE = "Welcome to the Rock Paper Scissors game!\n";
    static final String HAND_FIGURE = "Please select 1, 2, or 3 for ROCK, PAPER or SCISSORS.";

    private final MarkovChain markovChain;
    private final Score totalScore;
    private Hand userChoice;
    private Hand machineChoice;

    public GameServiceImpl() {
        this.markovChain = new MarkovChain();
        this.totalScore = new Score();
    }

    /**
     * Returns greetings message.
     *
     * @return greetings message
     */
    @Override
    public String welcomeMessage() {
        return WELCOME_MESSAGE;
    }

    /**
     * Returns select option message.
     *
     * @return select option message
     */
    @Override
    public String enterOptionsMessage() {
        return HAND_FIGURE;
    }

    /**
     * Returns user player choice.
     *
     * @param userChoice user player choice
     */
    @Override
    public void pickUserChoice(Hand userChoice) {
        if (userChoice == EMPTY) {
            throw new RpsException("Invalid user input.");
        }
        this.userChoice = userChoice;
    }

    /**
     * Returns machine player choice.
     *
     * @return machine player choice
     */
    @Override
    public Hand pickMachineChoice() {
        final var rndFloat = ThreadLocalRandom.current().nextFloat();
        this.machineChoice = this.markovChain.nextMove(rndFloat);
        return this.machineChoice;
    }

    /**
     * Updates the Markov Chain with the last game human player choice
     */
    @Override
    public void updateChain(Hand userChoice) {
        this.markovChain.updateChain(userChoice);
    }

    /**
     * Calculates game round result.
     *
     * @return winner of the round
     */
    @Override
    public Player calculateResult() {
        this.totalScore.incrementTotalGames();
        if (this.machineChoice == this.userChoice) {
            return Player.DRAW;
        }
        if (this.machineChoice.isWinBy(this.userChoice)) {
            this.totalScore.incrementGamesWonByUser();
            return Player.USER;
        }
        return Player.MACHINE;
    }

    /**
     * Returns game total result.
     *
     * @return game total result
     */
    @Override
    public Score getResults() {
        return this.totalScore;
    }
}
