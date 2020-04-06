package bowling;

import java.security.InvalidParameterException;

public class NormalFrame {

    private long frameNo;

    public NormalFrame(long frameNo) {
        if (frameNo <= 0) {
            throw new InvalidParameterException("required valid frame no");
        }

        this.frameNo = frameNo;
    }

    public long getFrameNo() {
        return frameNo;
    }
}
