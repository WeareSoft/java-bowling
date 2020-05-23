package bowling.view;

import bowling.Player;
import bowling.score.Score;

import java.util.Scanner;

public class InputView {
	private static Scanner scanner;

	public static Player askPlayerName() {
		scanner = new Scanner(System.in);
		System.out.print("플레이어 이름은(3 english letters)?: ");
		return Player.of(scanner.nextLine());
	}

	public static Score askScore(final int frameNo) {
		scanner = new Scanner(System.in);
		System.out.print(frameNo + "프레임 투구: ");
		return Score.of(scanner.nextInt());
	}
}
