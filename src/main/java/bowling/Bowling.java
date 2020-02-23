package bowling;

import bowling.frame.FirstPitchingFrame;
import bowling.frame.Frame;
import bowling.frame.result.FrameResult;
import bowling.score.Score;
import bowling.score.ScoreBoard;

import java.util.ArrayList;
import java.util.List;

public class Bowling {
	private final List<FrameResult> frameResults = new ArrayList<>();

	public void firstBowl(final Score score) {
		frameResults.clear();
		final Frame firstFrame = new FirstPitchingFrame(Frame.MIN_NO);
		bowl(score, firstFrame);
	}

	public void bowl(final Score score) {
		if (frameResults.isEmpty()) {
			firstBowl(score);
			return;
		}
		final Frame frame = getLastFrameResult().nextFrame();
		bowl(score, frame);
	}

	private void bowl(final Score score, final Frame frame) {
		frameResults.add(frame.pitch(score));
	}

	public boolean hasNext() {
		return frameResults.isEmpty() || getLastFrameResult().getFrameNo() <= Frame.MAX_NO;
	}

	public FrameResult getLastFrameResult() {
		return frameResults.get(frameResults.size() - 1);
	}

	public int getNextFrameNo() {
		return getLastFrameResult().getNextFrameNo();
	}

	public ScoreBoard getScoreBoard() {
		return new ScoreBoard(frameResults);
	}
}
