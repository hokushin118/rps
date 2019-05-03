package com.al.imc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

import com.al.imc.enums.Hand;
import com.al.imc.model.ComputerPlayer;
import com.al.imc.model.HumanPlayer;
import com.al.imc.model.Player;
import com.al.imc.utils.Constants;
import com.al.imc.utils.RPSHelper;

public class RPSGame {

	public static void main(String[] args) throws IOException {
		System.out.println(Constants.NO_OF_GAMES);
		
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numberOfGames = br.readLine();		
        int numberOfPlays = RPSHelper.getNumberOfPlays(numberOfGames);        
                   
        for (int i = 0; i < numberOfPlays; i++) {        	
        	System.out.println();
            System.out.printf(Constants.GAME_NO, i + 1);
            System.out.println();
            
            final Scanner scanner = new Scanner(System.in);
            final Player human = new HumanPlayer(scanner);
            final Supplier<Hand> strategy = () -> Hand.random(() -> ThreadLocalRandom.current()
                    .nextInt(Hand.values().length));
            final Player computer = new ComputerPlayer(strategy);
            
            final Game game = new Game(human, computer);

            game.run();

            game.printState(System.out);            
        }
    }

}
