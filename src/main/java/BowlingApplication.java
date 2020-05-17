import domain.BowlingGame;
import domain.FallingPin;
import domain.Player;
import domain.Players;
import input.BowlingGameInputtable;
import input.ConsoleBowlingGameInputInterface;
import output.ConsoleBowlingScorePresenter;

import java.util.Collections;

public class BowlingApplication {
    private static final int DEFAULT_BOWLING_MAX_FRAME = 10;
    private static BowlingGameInputtable inputManager = new ConsoleBowlingGameInputInterface();

    public static void main(String[] args) throws IllegalAccessException {
        String playerName = inputManager.getPlayerName();
        Player player = new Player(playerName);
        Players playerList = new Players(Collections.singletonList(player));
        BowlingGame bowlingGame = new BowlingGame(DEFAULT_BOWLING_MAX_FRAME, playerList);

        while (bowlingGame.hasNext()) {
            Player thisTurnPlayer = bowlingGame.nextPlayer();
            FallingPin fallingPinCount = inputManager.getFallingPint();
            thisTurnPlayer.bowl(fallingPinCount);
            ConsoleBowlingScorePresenter.print(bowlingGame);
        }

        System.out.println("--볼링 게임 끝--");
    }
}