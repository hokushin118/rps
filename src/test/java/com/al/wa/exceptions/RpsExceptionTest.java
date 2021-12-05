package com.al.wa.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Testing RpsException class")
class RpsExceptionTest {
    private static final String ERROR_MESSAGE = "Wrong input parameters...";

    @Test
    @DisplayName("Testing RpsException custom exception")
    void rpsExceptionClassAndMessageTest() {
        final var thrown = assertThrows(RpsException.class, this::throwRpsException);

        assertNotNull(thrown);
        assertTrue(thrown.getMessage().contains(ERROR_MESSAGE));
    }

    private void throwRpsException() {
        throw new RpsException(ERROR_MESSAGE);
    }
}
