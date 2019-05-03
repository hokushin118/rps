package com.al.imc.model;

import static org.junit.Assert.assertEquals;

import java.util.function.Supplier;

import org.junit.Test;

import com.al.imc.enums.Hand;

public class ComputerPlayerTest {

	@Test
	public void playsWithRockTest() {
		 Supplier<Hand> rock = () -> Hand.ROCK;
		 Player player = new ComputerPlayer(rock);
		 assertEquals(Hand.ROCK, player.plays());
	}
	
	@Test
	public void playsWithPaperTest() {
		 Supplier<Hand> paper = () -> Hand.PAPER;
		 Player player = new ComputerPlayer(paper);
		 assertEquals(Hand.PAPER, player.plays());
	}
	
	@Test
	public void playsWithScissorsTest() {
		 Supplier<Hand> scissors = () -> Hand.SCISSORS;
		 Player player = new ComputerPlayer(scissors);
		 assertEquals(Hand.SCISSORS, player.plays());
	}
	
	@Test
	public void getNameTest() {
		 Supplier<Hand> rock = () -> Hand.ROCK;
		 Player player = new ComputerPlayer(rock);
		 assertEquals("Computer", player.getName());
	}

}
