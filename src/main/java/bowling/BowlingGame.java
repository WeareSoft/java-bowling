package bowling;

import bowling.frame.Frame;
import bowling.view.InputView;
import bowling.view.ResultView;

public class BowlingGame {
	public static void main(String[] args) {
		final Player player = InputView.askPlayerName();
		final Bowling bowling = new Bowling();

		int nextFrameNo = Frame.MIN_NO;
		while (bowling.hasNext()) {
			bowling.bowl(InputView.askScore(nextFrameNo));
			ResultView.printScoreBoard(player, bowling.getScoreBoard());
			nextFrameNo = bowling.getNextFrameNo();
		}
	}
}
