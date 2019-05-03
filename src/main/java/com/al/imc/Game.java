package com.al.imc;

import java.io.PrintStream;

import com.al.imc.enums.GameResult;
import com.al.imc.model.Player;

/**
Game class contains rock paper scissor game logic.

*/
public class Game {

	private final Player playerOne;
	private final Player playerTwo;

	private GameResult result;

	public Game(final Player playerOne, final Player playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}

	public void run() {
		result = playerOne.plays().plays(playerTwo.plays());
	}

	public void printState(final PrintStream out) {
		String message = null;
		switch (result) {
		case WIN:
			message = String.format("%s won.", playerOne.getName());
			break;
		case LOSE:
			message = String.format("%s won.", playerTwo.getName());
			break;
		case DRAW:
			message = "It's a draw";
			break;
		default:
			break;
		}
		out.println(message);
	}

}
