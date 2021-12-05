package com.al.wa.exceptions;

/**
 * This exception class contains Rock Paper Scissor game custom exception.
 */
public class RpsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RpsException(String message) {
        super(message);
    }
}
