package com.al.imc.model;

import java.util.function.Supplier;

import com.al.imc.enums.Hand;

/**
ComputerPlayer class represents computer player.

*/
public class ComputerPlayer implements Player {

	private final Supplier<Hand> pick;

	public ComputerPlayer(final Supplier<Hand> pick) {
		this.pick = pick;
	}

	@Override
	public Hand plays() {
		return pick.get();
	}

	@Override
	public String getName() {
		return "Computer";
	}

}
