package com.al.wa;

import com.al.wa.enums.Hand;
import com.al.wa.enums.Player;
import com.al.wa.enums.YesNo;
import com.al.wa.services.GameService;
import com.al.wa.services.GameServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class RpsGame {
    private final GameService gameService;

    private RpsGame() {
        this.gameService = new GameServiceImpl();
    }

    public static void main(String[] args) {
        new RpsGame().play();
    }

    private void play() {
        final var scanner = new Scanner(System.in);
        String userWantsToExit;

        log.info(this.gameService.welcomeMessage());

        do {
            log.info(this.gameService.enterOptionsMessage());

            final var userChoice = Hand.valueOfInt(scanner.nextInt());

            this.gameService.pickUserChoice(userChoice);
            final var machineChoice = this.gameService.pickMachineChoice();
            final var winner = this.gameService.calculateResult();
            final var score = this.gameService.getResults();

            log.info("You played {} and the machine played {}",
                    userChoice.name(),
                    machineChoice.name());

            if (Player.USER == winner) {
                log.info("You won!");
            }
            if (Player.MACHINE == winner) {
                log.info("Machine won!");
            }
            if (Player.DRAW == winner) {
                log.info("Draw!");
            }

            log.info("You won {} games out of {}",
                    score.getGamesWonByUser(), score.getTotalGames());

            // Update the Markov Chain with the last game human player choice
            this.gameService.updateChain(userChoice);

            log.info("Continue playing ({}=Yes, {}=No)?",
                    YesNo.YES.getCode(), YesNo.NO.getCode());
            userWantsToExit = scanner.next();

        } while (userWantsToExit.equalsIgnoreCase(YesNo.YES.getCode()));
    }
}
