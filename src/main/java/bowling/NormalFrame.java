package bowling;

import java.security.InvalidParameterException;
import java.util.concurrent.atomic.AtomicLong;

public class NormalFrame {
    private static final int MIN_PINS = 0;
    private static final int MAX_SCORE = 10;
    private static final int MAX_COUNT = 2;

    private AtomicLong count;
    private long score;
    private FrameNo frameNo;

    public NormalFrame(long frameNo) {
        this.frameNo = new FrameNo(frameNo);
        this.count = new AtomicLong();
        this.score = 0;
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
        return score < MAX_SCORE && count.get() < MAX_COUNT;
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
