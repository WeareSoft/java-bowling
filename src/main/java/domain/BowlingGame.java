package domain;

public class BowlingGame {
    public final int MAX_FRAME;
    private final Players players;
    private int nowFrameNumber;

    public BowlingGame(int maxFrame, Players players) {
        this.MAX_FRAME = maxFrame;
        this.players = players;
    }

    public boolean hasNext() {
        return MAX_FRAME > nowFrameNumber;
    }

    public Player nextPlayer() {
        if (players.isLastPlayer()) {
            nowFrameNumber++;
        }

        return players.getCurrentPlayer();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|  NAME  |");
        for (int i = 0; i < MAX_FRAME; i++) {
            stringBuilder.append(String.format("  %2d   |", i + 1));
        }

        stringBuilder.append("\n").append(players);

        return stringBuilder.toString() + "\n";
    }
}
