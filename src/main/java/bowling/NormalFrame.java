package bowling;

import bowling.score.FrameScore;
import java.security.InvalidParameterException;

public class NormalFrame {

    private static final int MIN_PINS = 0;

    private FrameScore scores;
    private FrameNo frameNo;
    private BowlingThrowStrategy strategy;

    public NormalFrame(long frameNo) {
        this.frameNo = new FrameNo(frameNo);
        this.scores = new FrameScore();
        this.strategy = new NormalThrowStrategy();
    }

    public long getFrameNo() {
        return frameNo.value;
    }

    public void throwBowling(int droppedPins) {
        if (droppedPins < MIN_PINS) {
            throw new InvalidParameterException("required valid droppedPins");
        }

        if (isPossibleThrowing()) {
            scores.addScore(droppedPins);
        }
    }

    private boolean isPossibleThrowing() {
        return strategy.isPossibleThrowing(scores);
    }

    public ScoreType getScore() {
        return ScoreType.getScoreType(scores);
    }

    class FrameNo {

        private long value;

        FrameNo(long value) {
            if (value <= 0) {
                throw new InvalidParameterException("required valid frame no");
            }

            this.value = value;
        }
    }
}
