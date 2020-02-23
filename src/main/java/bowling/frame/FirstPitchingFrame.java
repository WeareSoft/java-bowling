package bowling.frame;

import bowling.frame.result.FrameResult;
import bowling.frame.result.Gutter;
import bowling.frame.result.Hit;
import bowling.frame.result.Strike;
import bowling.score.Score;

public class FirstPitchingFrame implements Frame {
	private final int frameNo;

	public FirstPitchingFrame(final int frameNo) {
		this.frameNo = frameNo;
	}

	@Override
	public FrameResult pitch(final Score score) {
		if (score.isTen()) {
			return Strike.of(frameNo);
		}
		if (score.isZero()){
			return Gutter.of(frameNo, true);
		}
		return Hit.of(frameNo, score);
	}

	@Override
	public int getFrameNo() {
		return frameNo;
	}
}
