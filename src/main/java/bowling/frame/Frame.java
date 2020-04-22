package bowling.frame;

import bowling.BowlingThrowStrategy;
import bowling.score.FrameScore;

public class Frame {

    private FrameScore scores;
    private FrameNo frameNo;
    private Frame nextFrame;

    public Frame(long frameNo, BowlingThrowStrategy bowlingThrowStrategy) {
        this(new FrameNo(frameNo), bowlingThrowStrategy);
    }

    public Frame(FrameNo frameNo, BowlingThrowStrategy bowlingThrowStrategy) {
        this.frameNo = frameNo;
        this.scores = new FrameScore(bowlingThrowStrategy);
    }

    public boolean isComplete() {
        return !scores.isPossibleThrowing() && frameNo.isFinalFrame();
    }

    public void throwBowling(int droppedPins) {
        scores.addScore(droppedPins);
        buildNextFrame();
    }

    private void buildNextFrame() {
        if (!scores.isPossibleThrowing() && !frameNo.isFinalFrame()) {
            FrameNo nextFrameNo = frameNo.getNextFrameNo();
            nextFrame = new Frame(nextFrameNo, BowlingThrowStrategy.build(nextFrameNo));
        }
    }

    /**
     * Getter
     */
    public long getFrameNo() {
        return frameNo.getValue();
    }

    public FrameScore getScore() {
        return scores;
    }

    public Frame getNextFrame() {
        return this.nextFrame;
    }
}
