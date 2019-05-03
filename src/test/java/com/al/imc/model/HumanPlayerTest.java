package com.al.imc.model;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class HumanPlayerTest {

	@Test
	public void getNameTest() {
		Scanner scanner = new Scanner(System.in);
		Player player = new HumanPlayer(scanner);
		assertEquals("Human", player.getName());
	}

}
