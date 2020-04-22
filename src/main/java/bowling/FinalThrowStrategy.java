package bowling;

import static bowling.score.UnitScore.MAX_SCORE;

import bowling.score.FrameScore;

public class FinalThrowStrategy implements BowlingThrowStrategy {

    @Override
    public boolean isPossibleThrowing(FrameScore frameScore) {
        return isBonusChance(frameScore) || frameScore.getCount() < MAX_COUNT;
    }

    private boolean isBonusChance(FrameScore frameScore) {
        return frameScore.getCount() == MAX_COUNT && frameScore.getPartScore(0, MAX_COUNT) == MAX_SCORE;
    }
}