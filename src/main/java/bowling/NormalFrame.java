package bowling;

import java.security.InvalidParameterException;
import java.util.concurrent.atomic.AtomicLong;

public class NormalFrame {

    private AtomicLong count;
    private long score = 0;
    private FrameNo frameNo;

    public NormalFrame(long frameNo) {
        this.frameNo = new FrameNo(frameNo);
        this.count = new AtomicLong();
    }

    public long getFrameNo() {
        return frameNo.value;
    }

    public void throwBowling(int droppedPins) {
        if (droppedPins < 0) {
            throw new InvalidParameterException("required valid droppedPins");
        }

        if (isPossibleThrowing()) {
            count.incrementAndGet();
            score += droppedPins;
        }
    }

    private boolean isPossibleThrowing() {
        return score < 10 && count.get() < 2;
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
