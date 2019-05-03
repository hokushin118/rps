package com.al.imc.utils;

import java.io.IOException;

/**
Collected methods of general utility.

*/
public final class RPSHelper {
	
	public static int getNumberOfPlays(final String inputString) throws IOException {
        int numberOfPlays = -1;
        while (numberOfPlays < 0) {
            numberOfPlays = parsePositiveArithmetic(inputString);
        }
        return numberOfPlays;
    }
	
	 private static int parsePositiveArithmetic(final String inputString) {
	        int userInput = -1;
	        try {
	            userInput = Integer.parseInt(inputString);
	        } catch (final NumberFormatException e) {
	            System.out.println("Invalid input!");
	        }
	        return userInput;
	    }
	
	 /**
	   The caller references the methods using <tt>RPSHelper.EMPTY_STRING</tt>, 
	   and so on. Thus, the caller should be prevented from constructing objects of 
	   this class, by declaring this private constructor. 
	  */
	private RPSHelper() {
		//this prevents even the native class from 
	    //calling this ctor as well :
	    throw new AssertionError();
	}

}
