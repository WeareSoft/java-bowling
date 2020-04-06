package bowling;

import java.security.InvalidParameterException;

public class NormalFrame {

    private FrameNo frameNo;

    public NormalFrame(long frameNo) {
        this.frameNo = new FrameNo(frameNo);
    }

    public long getFrameNo() {
        return frameNo.value;
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
