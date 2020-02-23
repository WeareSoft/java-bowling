package bowling.frame.result;

import bowling.frame.FirstPitchingFrame;
import bowling.frame.Frame;
import bowling.frame.SecondPitchingFrame;
import bowling.score.Score;

public class Gutter implements FrameResult {
	public static final String DISPLAY_STRING = "-";
	private final int frameNo;
	private final boolean isFirstPitching;

	public static Gutter of(final int frameNo, final boolean isFirstPitching) {
		return new Gutter(frameNo, isFirstPitching);
	}

	private Gutter(final int frameNo, final boolean isFirstPitching) {
		this.frameNo = frameNo;
		this.isFirstPitching = isFirstPitching;
	}

	@Override
	public Frame nextFrame() {
		if (isFirstPitching) {
			return new SecondPitchingFrame(getNextFrameNo(), Score.ZERO);
		}
		return new FirstPitchingFrame(getNextFrameNo());
	}

	@Override
	public Score getScore() {
		return Score.ZERO;
	}

	@Override
	public int getFrameNo() {
		return frameNo;
	}

	@Override
	public int getNextFrameNo() {
		if (isFirstPitching)
			return frameNo;
		return frameNo + 1;
	}

	@Override
	public String toString() {
		return DISPLAY_STRING;
	}
}
