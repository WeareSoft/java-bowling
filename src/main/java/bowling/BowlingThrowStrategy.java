package bowling;

import bowling.score.FrameScore;

public interface BowlingThrowStrategy {

    int MAX_COUNT = 2;

    boolean isPossibleThrowing(FrameScore frameScore);
}
