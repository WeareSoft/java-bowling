package bowling.score;

import bowling.frame.result.FrameResult;

import java.util.*;

public class ScoreBoard {
	private final Map<Integer, String> board = new HashMap<>();

	public ScoreBoard(final List<FrameResult> frameResults) {
		for (final FrameResult frameResult : frameResults) {
			final int frameNo = frameResult.getFrameNo();
			final String frameScore = board.get(frameNo);

			if (Objects.nonNull(frameScore)) {
				final String totalFrameScore = String.join("|", frameScore, frameResult.toString());
				board.put(frameNo, totalFrameScore);
				continue;
			}
			board.put(frameNo, frameResult.toString());
		}
	}
}