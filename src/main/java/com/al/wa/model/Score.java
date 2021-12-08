package com.al.wa.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class contains Rock Paper Scissor game related statistics.
 */
public class Score {
    private static final int INITIAL_VALUE = 0;

    private final AtomicInteger gamesWonByUser;
    private final AtomicInteger totalGames;

    public Score() {
        this.gamesWonByUser = new AtomicInteger(INITIAL_VALUE);
        this.totalGames = new AtomicInteger(INITIAL_VALUE);
    }

    public void incrementGamesWonByUser() {
        this.gamesWonByUser.getAndIncrement();
    }

    public void incrementTotalGames() {
        this.totalGames.getAndIncrement();
    }

    public int getGamesWonByUser() {
        return this.gamesWonByUser.get();
    }

    public int getTotalGames() {
        return this.totalGames.get();
    }
}
