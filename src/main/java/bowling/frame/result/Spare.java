package bowling.frame.result;

import bowling.frame.FirstPitchingFrame;
import bowling.frame.Frame;
import bowling.score.Score;

public class Spare implements FrameResult {
    static final String DISPLAY_STRING = "/";
	private final int frameNo;
	private final Score score;

	public static Spare of(final int frameNo, final Score score) {
		return new Spare(frameNo, score);
	}

	private Spare(final int frameNo, final Score score) {
		this.frameNo = frameNo;
		this.score = score;
	}

	@Override
	public Frame nextFrame() {
		return new FirstPitchingFrame(getNextFrameNo());
	}

	@Override
	public Score getScore() {
		return score;
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
