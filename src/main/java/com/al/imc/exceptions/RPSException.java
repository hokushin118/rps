package com.al.imc.exceptions;

/**
RPSException class contains rock paper scissor game custom exception.

*/
public class RPSException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RPSException(final String message)
	  {
	    super(message);
	  }
}
