package bowling;

import bowling.score.FrameScore;

public class FinalThrowStrategy implements BowlingThrowStrategy {

    private static final int MAX_SCORE = 10;

    @Override
    public boolean isPossibleThrowing(FrameScore frameScore) {
        return frameScore.getPartScore(0, 2) == MAX_SCORE;
    }
}