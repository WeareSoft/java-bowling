package bowling.frame.result;

import bowling.frame.Frame;
import bowling.frame.SecondPitchingFrame;
import bowling.score.Score;

public class Hit implements FrameResult {
	private final int frameNo;
	private final Score score;

	public static Hit of(final int frameNo, final Score score) {
		return new Hit(frameNo, score);
	}

	private Hit(final int frameNo, final Score score) {
		this.frameNo = frameNo;
		this.score = score;
	}

	@Override
	public Frame nextFrame() {
		return new SecondPitchingFrame(frameNo, score);
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
		return frameNo;
	}

	@Override
	public String toString() {
		return String.valueOf(score.toInt());
	}
}
