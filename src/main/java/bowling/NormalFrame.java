package bowling;

import java.security.InvalidParameterException;
import java.util.concurrent.atomic.AtomicLong;

public class NormalFrame {
    private static final int MIN_PINS = 0;

    private AtomicLong count;
    private long score;
    private FrameNo frameNo;
    private BowlingThrowStrategy strategy;

    public NormalFrame(long frameNo) {
        this.frameNo = new FrameNo(frameNo);
        this.count = new AtomicLong();
        this.score = 0;
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
            count.incrementAndGet();
            score += droppedPins;
        }
    }

    private boolean isPossibleThrowing() {
        return strategy.isPossibleThrowing(score, count.get());
    }

    public ScoreType getScore() {
        return ScoreType.getScoreType(count.get(), score);
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
