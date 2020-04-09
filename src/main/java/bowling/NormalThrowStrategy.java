package bowling;

import bowling.score.FrameScore;

public class NormalThrowStrategy implements BowlingThrowStrategy {

    private static final int MAX_COUNT = 2;
    private static final int MAX_SCORE = 10;

    @Override
    public boolean isPossibleThrowing(FrameScore frameScore) {
        return frameScore.getTotalScore() < MAX_SCORE && frameScore.getCount() < MAX_COUNT;
    }
}
