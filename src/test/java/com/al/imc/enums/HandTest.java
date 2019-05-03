package com.al.imc.enums;

import static org.junit.Assert.assertEquals;

import java.util.function.Supplier;

import org.junit.Test;

public class HandTest {

	@Test
	public void enumValueTest() {
		Hand rock = Hand.ROCK;
		assertEquals(Hand.valueOf("ROCK"), rock);

		Hand paper = Hand.PAPER;
		assertEquals(Hand.valueOf("PAPER"), paper);

		Hand scissors = Hand.SCISSORS;
		assertEquals(Hand.valueOf("SCISSORS"), scissors);
	}

	@Test
	public void enumPlaysRockVsRockEqualTest() {
		Hand hand = Hand.ROCK;
		GameResult result = hand.plays(Hand.ROCK);
		assertEquals(GameResult.DRAW, result);
	}

	@Test
	public void enumPlaysRockVsScissorsWinTest() {
		Hand hand = Hand.ROCK;
		GameResult result = hand.plays(Hand.SCISSORS);
		assertEquals(GameResult.WIN, result);
	}

	@Test
	public void enumPlaysRockVsPaperLoseTest() {
		Hand hand = Hand.ROCK;
		GameResult result = hand.plays(Hand.PAPER);
		assertEquals(GameResult.LOSE, result);
	}

	@Test
	public void enumPlaysPaperVsPaperEqualTest() {
		Hand hand = Hand.PAPER;
		GameResult result = hand.plays(Hand.PAPER);
		assertEquals(GameResult.DRAW, result);
	}

	@Test
	public void enumPlaysPaperVsRockWinTest() {
		Hand hand = Hand.PAPER;
		GameResult result = hand.plays(Hand.ROCK);
		assertEquals(GameResult.WIN, result);
	}

	@Test
	public void enumPlaysPaperVsScissorLoseTest() {
		Hand hand = Hand.PAPER;
		GameResult result = hand.plays(Hand.SCISSORS);
		assertEquals(GameResult.LOSE, result);
	}

	@Test
	public void enumPlaysScissorsVsScissorsEqualTest() {
		Hand hand = Hand.SCISSORS;
		GameResult result = hand.plays(Hand.SCISSORS);
		assertEquals(GameResult.DRAW, result);
	}

	@Test
	public void enumPlaysScissorsVsPaperWinTest() {
		Hand hand = Hand.SCISSORS;
		GameResult result = hand.plays(Hand.PAPER);
		assertEquals(GameResult.WIN, result);
	}

	@Test
	public void enumPlaysScissorsVsRockLoseTest() {
		Hand hand = Hand.SCISSORS;
		GameResult result = hand.plays(Hand.ROCK);
		assertEquals(GameResult.LOSE, result);
	}

	@Test
	public void enumSupplierTest() {
		Supplier<Hand> rock = () -> Hand.ROCK;
		assertEquals(Hand.ROCK, rock.get());

		Supplier<Hand> paper = () -> Hand.PAPER;
		assertEquals(Hand.PAPER, paper.get());

		Supplier<Hand> scissors = () -> Hand.SCISSORS;
		assertEquals(Hand.SCISSORS, scissors.get());
	}

	@Test
	public void enumRandomNumberGeneratorRockTest() {
		Supplier<Integer> randomNumberGenerator = () -> 0;

		assertEquals(Integer.valueOf(0), randomNumberGenerator.get());

		Hand hand = Hand.random(randomNumberGenerator);

		assertEquals(Hand.ROCK, hand);
	}

	@Test
	public void enumRandomNumberGeneratorPaperTest() {
		Supplier<Integer> randomNumberGenerator = () -> 1;

		assertEquals(Integer.valueOf(1), randomNumberGenerator.get());

		Hand hand = Hand.random(randomNumberGenerator);

		assertEquals(Hand.PAPER, hand);
	}

	@Test
	public void enumRandomNumberGeneratorScissorsTest() {
		Supplier<Integer> randomNumberGenerator = () -> 2;

		assertEquals(Integer.valueOf(2), randomNumberGenerator.get());

		Hand hand = Hand.random(randomNumberGenerator);

		assertEquals(Hand.SCISSORS, hand);
	}

	@SuppressWarnings("unused")
	@Test(expected = IndexOutOfBoundsException.class)
	public void enumRandomNumberGeneratorErrorTest() {
		Supplier<Integer> randomNumberGenerator = () -> 3;

		assertEquals(Integer.valueOf(3), randomNumberGenerator.get());

		Hand hand = Hand.random(randomNumberGenerator);
	}

}
