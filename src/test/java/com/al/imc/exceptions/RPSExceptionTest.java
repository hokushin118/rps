package com.al.imc.exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RPSExceptionTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void rpsExceptionClassAndMessageTest() {
		thrown.expect(RPSException.class);
		thrown.expectMessage("This is RPSException exception!");

		throw new RPSException("This is RPSException exception!");
	}

}
