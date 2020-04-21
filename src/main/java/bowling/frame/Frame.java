package bowling.frame;

import bowling.BowlingThrowStrategy;
import bowling.score.FrameScore;
import java.security.InvalidParameterException;

public class Frame {

    private static final int MIN_PINS = 0;

    private FrameScore scores;
    private FrameNo frameNo;
    private Frame nextFrame;
    private BowlingThrowStrategy strategy;

    public Frame(long frameNo, BowlingThrowStrategy bowlingThrowStrategy) {
        this(new FrameNo(frameNo), bowlingThrowStrategy);
    }

    public Frame(FrameNo frameNo, BowlingThrowStrategy bowlingThrowStrategy) {
        this.frameNo = frameNo;
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
        if (!isPossibleThrowing() && !frameNo.isFinalFrame()) {
            FrameNo nextFrameNo = frameNo.getNextFrameNo();

            nextFrame = new Frame(nextFrameNo, BowlingThrowStrategy.build(nextFrameNo));
        }
    }

    public boolean isComplete() {
        return !isPossibleThrowing() && frameNo.isFinalFrame();
    }

    private boolean isPossibleThrowing() {
        return strategy.isPossibleThrowing(scores);
    }

    public FrameScore getScore() {
        return scores;
    }

    public Frame getNextFrame() {
        return this.nextFrame;
    }
}
