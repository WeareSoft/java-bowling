package bowling.frame;

import bowling.frame.result.*;
import bowling.score.Score;

public class FinalFrame implements Frame {
	@Override
	public FrameResult pitch(final Score score) {
		return FinalResult.of(score);
	}

	@Override
	public int getFrameNo() {
		return Frame.MAX_NO;
	}
}
