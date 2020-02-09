package output;

import domain.BollingGame;
import domain.FallingPin;
import domain.Frame;
import domain.Player;

import java.util.List;

public interface BollingScorePresentable {
    void show(final List<Player> players);

    void show(Frame frame);

    void show(FallingPin fallingPin);
}
