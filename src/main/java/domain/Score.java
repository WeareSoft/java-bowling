package domain;

public class Score {
    public final static Score ZERO = Score.of(0);
    public final static Score NOT_DETERMINED = Score.of(-1);

    private int score;

    private Score(int score) {
        this.score = score;
    }

    public static Score of(int score) {
        return new Score(score);
    }

    public int value() {
        return score;
    }

    @Override
    public String toString() {
        if (this.equals(NOT_DETERMINED)) {
            return "    ";
        }

        return String.valueOf(score);
    }
}
