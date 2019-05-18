package com.al.imc.model;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.al.imc.RPSGame;
import com.al.imc.enums.Hand;
import com.al.imc.exceptions.RPSException;
import com.al.imc.utils.Constants;

/**
ComputerPlayer class represents human player.

*/
public class HumanPlayer implements Player {
	private static final Logger logger = Logger.getLogger(RPSGame.class);
	
	private final Scanner scanner;

	public HumanPlayer(final Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public Hand plays() {
		System.out.println(Constants.HAND_FIGURE);
		int choice = this.scanner.nextInt();

		switch (choice) {
		case 1:
			System.out.println("You've selected: ROCK");
			return Hand.ROCK;
		case 2:
			System.out.println("You've selected: PAPER");
			return Hand.PAPER;
		case 3:
			System.out.println("You've selected: SCISSORS");
			return Hand.SCISSORS;
		default:
			logger.error("Invalid input.");
			throw new RPSException("Invalid input.");
		}
	}

	@Override
	public String getName() {
		return "Human";
	}
}
