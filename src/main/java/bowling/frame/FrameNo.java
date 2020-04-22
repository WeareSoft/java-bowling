package bowling.frame;

import java.security.InvalidParameterException;

/**
 * Frame 번호에 대한 책임을 가지고 있다.
 */
public class FrameNo {

    public static final int START_FRAME_NO = 1;
    public static final int FINAL_FRAME_NO = 10;

    private long value;

    FrameNo(long value) {
        if (value < START_FRAME_NO) {
            throw new InvalidParameterException("required valid frame no");
        }

        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public FrameNo getNextFrameNo() {
        return new FrameNo(value + 1);
    }

    public boolean isFinalFrame() {
        return value == FINAL_FRAME_NO;
    }
}
