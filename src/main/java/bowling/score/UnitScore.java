package bowling.score;

public class UnitScore {

    public static final long MAX_SCORE = 10;
    private long score;

    public UnitScore(long droppedPins) {
        this.score = droppedPins;
    }

    public long getScore() {
        return this.score;
    }
}
