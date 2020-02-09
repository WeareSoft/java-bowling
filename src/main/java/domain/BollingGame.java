package domain;

import output.BollingScorePresentable;

import java.util.List;

public class BollingGame {
    public final int MAX_FRAME;
    private final List<Player> players;
    private Player currentPlayer;
    private int currentFrameNumber;

    public BollingGame(int maxFrame, List<Player> players) {
        this.MAX_FRAME = maxFrame;
        this.players = players;
        this.currentPlayer = players.get(0);
    }

    public boolean hasNext() {
        return MAX_FRAME > currentFrameNumber;
    }

    public Player nextPlayer() {
        if (isLastPlayer()) {
            currentPlayer = players.get(0);
            currentFrameNumber++;
        }

        return currentPlayer;
    }
    private boolean isLastPlayer() {
        int lastPlayerIndex = players.size() - 1;
        Player lastPlayer = players.get(lastPlayerIndex);
        return lastPlayer.equals(currentPlayer);
    }

    public int getCurrentFrameNumber() {
        return currentFrameNumber;
    }

    public void printScore(BollingScorePresentable presenter) {
        presenter.show(players);
    }
}
