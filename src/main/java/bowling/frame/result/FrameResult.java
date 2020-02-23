package bowling.frame.result;

import bowling.frame.Frame;
import bowling.score.Score;

public interface FrameResult {
	Frame nextFrame(); // TODO: FinalFrame 조건 추가

	Score getScore();

	int getFrameNo();

	int getNextFrameNo();
}
