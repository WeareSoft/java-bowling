package domain;

public class Score {
    public final static Score NOT_DETERMINED = Score.of(0);

    private int score;

    private Score(int score) {
        this.score = score;
    }

    public static Score of(int score) {
        return new Score(score);
    }

    public Score add(Score score) {
        this.score += score.score;
        return Score.of(this.score);
    }

    @Override
    public String toString() {
        if (this.equals(NOT_DETERMINED)) {
            return "  ";
        }

        return String.format("%2d", score);
    }
}
