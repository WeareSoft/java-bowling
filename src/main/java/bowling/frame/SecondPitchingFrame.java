package bowling.frame;

import bowling.frame.result.FrameResult;
import bowling.frame.result.Gutter;
import bowling.frame.result.Miss;
import bowling.frame.result.Spare;
import bowling.score.Score;

public class SecondPitchingFrame implements Frame {
	private final int frameNo;
	private final Score beforeScore;

	public SecondPitchingFrame(final int frameNo, final Score beforeScore) {
		this.frameNo = frameNo;
		this.beforeScore = beforeScore;
	}

	@Override
	public FrameResult pitch(Score score) {
		Score totalScore = beforeScore.add(score);
		if (totalScore.isTen()) {
			return Spare.of(getFrameNo(), score);
		}
		if (totalScore.isZero()) {
			return Gutter.of(getFrameNo(), false);
		}
		return Miss.of(getFrameNo(), score);
	}

	@Override
	public int getFrameNo() {
		return frameNo;
	}
}
