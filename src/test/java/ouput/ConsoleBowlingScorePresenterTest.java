package ouput;

import domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class ConsoleBowlingScorePresenterTest {
    @Test
    @DisplayName("콘솔 출력 확인")
    void scorePrintTest() {


        FrameCollection frameCollection = new FrameCollection();
        frameCollection.add(new Frame(new FallingPin(10), new FallingPin(0)));
        frameCollection.add(new Frame(new FallingPin(3), new FallingPin(7)));
        frameCollection.add(new Frame(new FallingPin(4), new FallingPin(4)));
        frameCollection.add(new Frame(new FallingPin(4), new FallingPin(0)));
        frameCollection.add(new Frame(new FallingPin(0), new FallingPin(4)));
        frameCollection.add(new Frame(new FallingPin(0), new FallingPin(0)));

        Player player = new Player("LSH", frameCollection);

        BowlingGame bowlingGame = new BowlingGame(10, new Players(Collections.singletonList(player)));
        System.out.println(bowlingGame);
    }
}
