import domain.BollingGame;
import domain.Player;
import input.BollingGameInputtable;
import input.ConsoleBollingGameInputInterface;
import output.BollingScorePresentable;
import output.ConsoleBollingScorePresenter;

import java.util.Collections;
import java.util.List;

public class BollingApplication {
    private static final int DEFAULT_BOLLING_MAX_FRAME = 10;
    private static BollingGameInputtable inputManager = new ConsoleBollingGameInputInterface();
    private static final BollingScorePresentable bollingScorePresenter = new ConsoleBollingScorePresenter();

    public static void main(String[] args) {
        String playerName = inputManager.getPlayerName();
        Player player = new Player(playerName);
        List<Player> playerList = Collections.singletonList(player);
        BollingGame bollingGame = new BollingGame(DEFAULT_BOLLING_MAX_FRAME, playerList);

        while (bollingGame.hasNext()) {
            Player thisTurnPlayer = bollingGame.nextPlayer();
            int fallingPinCount = inputManager.getFallingPint();
            thisTurnPlayer.bowl(fallingPinCount);
            bollingGame.printScore(bollingScorePresenter);
        }

        System.out.println("--볼링 게임 끝--");
    }
}
