package bowling.frame;

import bowling.frame.result.FrameResult;
import bowling.score.Score;

public interface Frame {
	int MIN_NO = 1;
	int MAX_NO = 10;

	FrameResult pitch(final Score score);

	int getFrameNo();
}
