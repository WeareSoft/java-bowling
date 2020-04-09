package bowling;

import bowling.score.FrameScore;
import java.security.InvalidParameterException;

public class NormalFrame {

    private static final int MIN_PINS = 0;
    public static final int FINAL_FRAME_NO = 10;

    private FrameScore scores;
    private FrameNo frameNo;
    private NormalFrame nextFrame;
    private BowlingThrowStrategy strategy;

    public NormalFrame(long frameNo, BowlingThrowStrategy bowlingThrowStrategy) {
        this.frameNo = new FrameNo(frameNo);
        this.scores = new FrameScore();
        this.strategy = bowlingThrowStrategy;
    }

    public long getFrameNo() {
        return frameNo.value;
    }

    public void throwBowling(int droppedPins) {
        if (droppedPins < MIN_PINS) {
            throw new InvalidParameterException("required valid droppedPins");
        }

        addScore(droppedPins);

        buildNextFrame();
    }

    private void addScore(int droppedPins) {
        if (isPossibleThrowing()) {
            scores.addScore(droppedPins);
        }
    }

    private void buildNextFrame() {
        if (!isPossibleThrowing() && !isFinalFrame(frameNo.value)) {
            long nextFrameNo = frameNo.value + 1;
            BowlingThrowStrategy throwStrategy = new NormalThrowStrategy();
            if (isFinalFrame(nextFrameNo)) {
                throwStrategy = new FinalThrowStrategy();
            }

            nextFrame = new NormalFrame(nextFrameNo, throwStrategy);
        }
    }

    private boolean isPossibleThrowing() {
        return strategy.isPossibleThrowing(scores);
    }

    private boolean isFinalFrame(long frameNo) {
        return frameNo == FINAL_FRAME_NO;
    }

    public ScoreType getScore() {
        return ScoreType.getScoreType(scores);
    }

    public NormalFrame getNextFrame() {
        return this.nextFrame;
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
