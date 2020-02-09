package output;

import domain.FallingPin;
import domain.Frame;
import domain.Player;

import java.util.List;

public class ConsoleBollingScorePresenter implements BollingScorePresentable {

    private final static String STRIKE_SYMBOL = "X";
    private final static String SPARE_SYMBOL = "/";
    private final static String MISS_SYMBOL = "-";

    @Override
    public void show(final List<Player> players) {
        // print about player info (score)
    }

    @Override
    public void show(Frame frame) {
        StringBuilder stringBuilder = new StringBuilder();

        FallingPin first = frame.getFirst();
        FallingPin second = frame.getSecond();

        switch (frame.getStatus()) {
            case STRIKE:
                stringBuilder.append(STRIKE_SYMBOL);
                break;
            case SPARE:
                stringBuilder.append(first.value() + "|" + SPARE_SYMBOL);
                break;
            default:
                String firstValue = first.value() == 0 ? MISS_SYMBOL : String.valueOf(first.value());
                String secondValue = second.value() == 0 ? MISS_SYMBOL : String.valueOf(second.value());
                stringBuilder.append(firstValue + "|" + secondValue);
                break;
        }
        System.out.println(stringBuilder);
    }

    @Override
    public void show(FallingPin fallingPin) {

    }
}
