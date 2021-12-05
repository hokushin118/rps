package com.al.wa.enums;

/**
 * This enum contains Rock Paper Scissor game options.
 */
public enum Hand {
    ROCK(1, 2),
    PAPER(2, 3),
    SCISSORS(3, 1),
    EMPTY(-1, -1);

    private final int id;
    private final int winBy;

    Hand(int id, int winBy) {
        this.id = id;
        this.winBy = winBy;
    }

    public static Hand valueOfInt(int userEnteredOption) {
        for (final var hand : Hand.values()) {
            if (userEnteredOption == hand.id) {
                return hand;
            }
        }
        return EMPTY;
    }

    public boolean isWinBy(Hand hand) {
        return this.winBy == hand.id;
    }
}
