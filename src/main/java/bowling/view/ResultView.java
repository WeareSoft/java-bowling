package bowling.view;

import bowling.Player;
import bowling.frame.Frame;
import bowling.score.ScoreBoard;

import java.util.Objects;

public class ResultView {
	public static void printScoreBoard(final Player player, final ScoreBoard scoreBoard) {
		System.out.print("| NAME\t");
		for (int i = Frame.MIN_NO; i <= Frame.MAX_NO; i++) {
			System.out.print("|\t" + i + "\t");
		}
		System.out.println("|");

		System.out.print("| " + player.getName() + "\t");
		for (int i = Frame.MIN_NO; i <= Frame.MAX_NO; i++) {
			final String score = Objects.nonNull(scoreBoard.getFrameScore(i)) ? scoreBoard.getFrameScore(i) : "";
			System.out.print("|\t" + score + "\t");
		}
		System.out.println("|\n");
	}
}
