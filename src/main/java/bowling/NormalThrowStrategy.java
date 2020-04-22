package bowling;

import bowling.score.FrameScore;
import bowling.score.UnitScore;

public class NormalThrowStrategy implements BowlingThrowStrategy {

    @Override
    public boolean isPossibleThrowing(FrameScore frameScore) {
        return frameScore.getTotalScore() < UnitScore.MAX_SCORE && frameScore.getCount() < MAX_COUNT;
    }
}
