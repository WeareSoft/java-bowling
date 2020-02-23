package bowling.frame.result;

import bowling.frame.Frame;
import bowling.score.Score;

public class FinalResult implements FrameResult {
	private final Score score;

	public static FinalResult of(final Score score) {
		return new FinalResult(score);
	}

	private FinalResult(final Score score) {
		this.score = score;
	}

	@Override
	public Frame nextFrame() {
		throw new IllegalArgumentException("마지막 프레임");
	}

	@Override
	public Score getScore() {
		return score;
	}

	@Override
	public int getFrameNo() {
		return Frame.MAX_NO;
	}

	@Override
	public int getNextFrameNo() {
		return Frame.MAX_NO;
	}

	@Override
	public String toString() {
		if (score.isTen()) {
			return Strike.DISPLAY_STRING;
		}
		if (score.isZero()) {
			return Gutter.DISPLAY_STRING;
		}
		return score.toString();
	}
}
