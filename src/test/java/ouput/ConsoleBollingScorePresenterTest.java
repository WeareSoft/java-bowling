package ouput;

import domain.FallingPin;
import domain.Frame;
import domain.FrameCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConsoleBollingScorePresenterTest {
    @Test
    @DisplayName("콘솔 출력 확인")
    void scorePrintTest() {
        FrameCollection frameCollection = new FrameCollection();
        frameCollection.add(new Frame(new FallingPin(10), new FallingPin(0)));
    }
}
