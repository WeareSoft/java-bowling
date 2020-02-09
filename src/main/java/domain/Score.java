package domain;

public class Score {
    public final static Score ZERO_SCORE = Score.of(FallingPin.MISS);
    private int score;

    private Score(FallingPin pins) {
        this.score = score;
    }

    public static Score of(FallingPin pin) {
        return new Score(pin);
    }
}
