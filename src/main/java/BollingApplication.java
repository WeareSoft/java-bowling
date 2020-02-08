import domain.BollingGame;
import domain.Player;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BollingApplication {
    private static final int DEFAULT_BOLLING_MAX_FRAME = 10;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("이름: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        List<Player> playerList = Collections.singletonList(player);
        BollingGame bollingGame = new BollingGame(DEFAULT_BOLLING_MAX_FRAME, playerList);

        while (bollingGame.hasNext()) {
            Player thisTurnPlayer = bollingGame.nextPlayer();
            System.out.println("쓰러트린 핀: ");
            int fallingPinCount = scanner.nextInt();
            thisTurnPlayer.bowl(fallingPinCount);
        }

        System.out.println("--볼링 게임 끝--");
    }

    private static void printScore(BollingGame bollingGame) {
        // print about game score...
    }
}
