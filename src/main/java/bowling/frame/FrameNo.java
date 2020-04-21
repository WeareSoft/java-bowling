package bowling.frame;

import java.security.InvalidParameterException;

public class FrameNo {

    public static final int START_FRAME_NO = 1;
    public static final int FINAL_FRAME_NO = 10;

    private long value;

    FrameNo(long value) {
        if (value <= 0) {
            throw new InvalidParameterException("required valid frame no");
        }

        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
