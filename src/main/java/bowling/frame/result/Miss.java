package bowling.frame.result;

import bowling.frame.FirstPitchingFrame;
import bowling.frame.Frame;
import bowling.score.Score;

public class Miss implements FrameResult {
	private final int frameNo;
	private final Score score;

	public static Miss of(final int frameNo, final Score score) {
		return new Miss(frameNo, score);
	}

	private Miss(final int frameNo, final Score score) {
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
		return score.isZero() ? "-" : String.valueOf(score.toInt());
	}
}
