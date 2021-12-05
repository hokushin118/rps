package com.al.wa;

import com.al.wa.enums.Hand;
import com.al.wa.enums.Player;
import com.al.wa.enums.YesNo;
import com.al.wa.services.GameService;
import com.al.wa.services.GameServiceImpl;

import java.util.Scanner;

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

        System.out.print(this.gameService.welcomeMessage());

        do {
            System.out.println(this.gameService.enterOptionsMessage());

            final var userChoice = Hand.valueOfInt(scanner.nextInt());

            this.gameService.pickUserChoice(userChoice);
            final var machineChoice = this.gameService.pickMachineChoice();
            final var winner = this.gameService.calculateResult();
            final var score = this.gameService.getResults();

            System.out.printf("You played %s and the machine played %s \n",
                    userChoice.name(),
                    machineChoice.name());

            if (Player.USER == winner) {
                System.out.println("You won!");
            }
            if (Player.MACHINE == winner) {
                System.out.println("Machine won!");
            }
            if (Player.DRAW == winner) {
                System.out.println("Draw!");
            }

            System.out.printf("You won %d games out of %d \n",
                    score.getGamesWonByUser(), score.getTotalGames());

            // Update the Markov Chain with the last game human player choice
            this.gameService.updateChain(userChoice);

            System.out.printf("Continue playing (%s=Yes, %s=No)?",
                    YesNo.YES.getCode(), YesNo.NO.getCode());
            userWantsToExit = scanner.next();

        } while (userWantsToExit.equalsIgnoreCase(YesNo.YES.getCode()));
    }
}
