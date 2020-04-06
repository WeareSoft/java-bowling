package bowling;

import java.security.InvalidParameterException;

public class NormalFrame {
    private long score = 0;
    private FrameNo frameNo;

    public NormalFrame(long frameNo) {
        this.frameNo = new FrameNo(frameNo);
    }

    public long getFrameNo() {
        return frameNo.value;
    }

    public void throwBowling(int droppedPins) {
        score += droppedPins;
    }

    public ScoreType getScore() {
        return score == 10 ? ScoreType.Strike : null;
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
