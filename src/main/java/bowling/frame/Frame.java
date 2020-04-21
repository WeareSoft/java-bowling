package bowling.frame;

import static bowling.frame.FrameNo.FINAL_FRAME_NO;

import bowling.BowlingThrowStrategy;
import bowling.FinalThrowStrategy;
import bowling.NormalThrowStrategy;
import bowling.score.FrameScore;
import java.security.InvalidParameterException;

public class Frame {

    private static final int MIN_PINS = 0;

    private FrameScore scores;
    private FrameNo frameNo;
    private Frame nextFrame;
    private BowlingThrowStrategy strategy;

    public Frame(long frameNo, BowlingThrowStrategy bowlingThrowStrategy) {
        this.frameNo = new FrameNo(frameNo);
        this.scores = new FrameScore();
        this.strategy = bowlingThrowStrategy;
    }

    public long getFrameNo() {
        return frameNo.getValue();
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
        if (!isPossibleThrowing() && !isFinalFrame(frameNo.getValue())) {
            long nextFrameNo = frameNo.getValue() + 1;
            BowlingThrowStrategy throwStrategy = new NormalThrowStrategy();
            if (isFinalFrame(nextFrameNo)) {
                throwStrategy = new FinalThrowStrategy();
            }

            nextFrame = new Frame(nextFrameNo, throwStrategy);
        }
    }

    private boolean isPossibleThrowing() {
        return strategy.isPossibleThrowing(scores);
    }

    private boolean isFinalFrame(long frameNo) {
        return frameNo == FINAL_FRAME_NO;
    }

    public boolean isComplete() {
        return !isPossibleThrowing() && isFinalFrame(frameNo.getValue());
    }

    public FrameScore getScore() {
        return scores;
    }

    public Frame getNextFrame() {
        return this.nextFrame;
    }
}
