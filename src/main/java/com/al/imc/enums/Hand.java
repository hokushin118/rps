package com.al.imc.enums;

import java.util.function.Supplier;

/**
Hand enum contains rock paper scissor game options and logic for matching two options.

*/
public enum Hand {
	ROCK, PAPER, SCISSORS;

	private Hand winsAgainst;

	static {
		ROCK.winsAgainst = SCISSORS;
		PAPER.winsAgainst = ROCK;
		SCISSORS.winsAgainst = PAPER;
	}

	public static Hand random(final Supplier<Integer> randomNumberGenerator) {
		return values()[randomNumberGenerator.get()];
	}

	public GameResult plays(final Hand opponent) {
		System.out.println(String.format("%s vs %s", this.toString(), opponent.toString()));
		if (this.equals(opponent)) {
			return GameResult.DRAW;
		}

		if (opponent.equals(winsAgainst)) {
			return GameResult.WIN;
		}

		return GameResult.LOSE;
	}
}
