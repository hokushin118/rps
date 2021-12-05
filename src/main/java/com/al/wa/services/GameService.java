package com.al.wa.services;

import com.al.wa.enums.Hand;
import com.al.wa.enums.Player;
import com.al.wa.model.Score;

/**
 * This interface describes a Rock Paper Scissor game.
 */
public interface GameService {
    String welcomeMessage();

    String enterOptionsMessage();

    void pickUserChoice(Hand userChoice);

    Hand pickMachineChoice();

    void updateChain(Hand userChoice);

    Player calculateResult();

    Score getResults();
}
