package com.al.imc.utils;

/**
Collected constants of general utility.

<P>All members of this class are immutable. 

*/
public final class Constants {
	
	 /** Game message - <tt>number of games</tt>*/
	public static final String NO_OF_GAMES = "How many times would you like to play?";
	/** Game message - <tt>game number</tt>*/
	public static final String GAME_NO = "Game no. %d\n";	
	/** Game message - <tt>Select hand figure</tt>*/
	public static final String HAND_FIGURE = "Select 1, 2, or 3 for ROCK, PAPER, SCISSORS.";	
	
	 /**
	   The caller references the constants using <tt>Constants.EMPTY_STRING</tt>, 
	   and so on. Thus, the caller should be prevented from constructing objects of 
	   this class, by declaring this private constructor. 
	  */
	private Constants() {
		//this prevents even the native class from 
	    //calling this ctor as well :
	    throw new AssertionError();
	}

}
