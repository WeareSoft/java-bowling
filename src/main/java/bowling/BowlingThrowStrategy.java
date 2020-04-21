package bowling;

import bowling.frame.FrameNo;
import bowling.score.FrameScore;

public interface BowlingThrowStrategy {

    int MAX_COUNT = 2;

    static BowlingThrowStrategy build(FrameNo frameNo) {
        if (frameNo.isFinalFrame()) {
            return new FinalThrowStrategy();
        }

        return new NormalThrowStrategy();
    }

    boolean isPossibleThrowing(FrameScore frameScore);
}
