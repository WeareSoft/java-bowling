package bowling;

public class NormalThrowStrategy implements BowlingThrowStrategy {

    private static final int MAX_COUNT = 2;
    private static final int MAX_SCORE = 10;

    @Override
    public boolean isPossibleThrowing(long score, long count) {
        return score < MAX_SCORE && count < MAX_COUNT;
    }
}
