package com.al.imc.enums;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameResultTest {

	@Test
	public void enumValueTest() {
		GameResult win = GameResult.WIN;
		assertEquals(GameResult.valueOf("WIN"), win);

		GameResult draw = GameResult.DRAW;
		assertEquals(GameResult.valueOf("DRAW"), draw);

		GameResult lose = GameResult.LOSE;
		assertEquals(GameResult.valueOf("LOSE"), lose);
	}

}
