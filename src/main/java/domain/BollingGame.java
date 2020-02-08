package domain;

import output.BollingScorePresentable;

import java.util.List;

public class BollingGame {
    public final int MAX_FRAME;
    private List<Player> players;

    public BollingGame(int maxFrame, List<Player> players) {
        this.MAX_FRAME = maxFrame;
        this.players = players;
    }

    public boolean hasNext() {
        return false;
    }

    public Player nextPlayer() {
        return null;
    }

    public void printScore(BollingScorePresentable presenter) {
        presenter.show(this);
    }
}
