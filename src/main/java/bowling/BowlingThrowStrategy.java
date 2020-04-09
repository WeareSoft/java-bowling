package bowling;

import bowling.score.FrameScore;

public interface BowlingThrowStrategy {

    boolean isPossibleThrowing(FrameScore frameScore);
}
