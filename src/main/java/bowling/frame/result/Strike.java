package bowling.frame.result;

import bowling.frame.FirstPitchingFrame;
import bowling.frame.Frame;
import bowling.score.Score;

public class Strike implements FrameResult {
	public static final String DISPLAY_STRING = "X";
	private final int frameNo;

	public static Strike of(final int frameNo) {
		return new Strike(frameNo);
	}

	private Strike(final int frameNo) {
		this.frameNo = frameNo;
	}

	@Override
	public Frame nextFrame() {
		return new FirstPitchingFrame(getNextFrameNo());
	}

	@Override
	public Score getScore() {
		return Score.TEN;
	}

	@Override
	public int getFrameNo() {
		return frameNo;
	}

	@Override
	public int getNextFrameNo() {
		return frameNo + 1;
	}

	@Override
	public String toString() {
		return DISPLAY_STRING;
	}
}
