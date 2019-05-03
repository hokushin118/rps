package com.al.imc.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RPSHelper.class })
public class RPSHelperTest {

	@Test
	public void getNumberOfPlaysTest() throws IOException {
		PowerMockito.mockStatic(RPSHelper.class);
		int number = 10;

		when(RPSHelper.getNumberOfPlays(anyString())).thenReturn(number);
		int expected = 10;

		int actual = RPSHelper.getNumberOfPlays("10");

		verify(RPSHelper.class);
		assertEquals(expected, actual);
	}

	@Test
	public void parsePositiveArithmeticTest() throws Exception {
		PowerMockito.spy(RPSHelper.class);

		PowerMockito.doReturn(10).when(RPSHelper.class, "parsePositiveArithmetic", "10");

		int expected = 10;

		int actual = RPSHelper.getNumberOfPlays("10");

		verify(RPSHelper.class);

		assertNotNull(actual);
		assertEquals(expected, actual);
	}

}
