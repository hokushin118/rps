package com.al.wa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("Testing RpsGame class")
class RpsGameTest {

    @Test
    @DisplayName("Testing constructor")
    void main() {
        assertDoesNotThrow(() -> new RpsGame());
    }
}