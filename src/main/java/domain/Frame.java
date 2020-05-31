package domain;

import java.util.Objects;

import static domain.Frame.FrameStatus.*;

public class Frame implements Scorable {
    public final static int DEFAULT_BOWLING_PIN = 10;
    public final static Frame NONE_FRAME = new Frame();

    private FallingPin first = FallingPin.NONE;
    private FallingPin second = FallingPin.NONE;

    private Frame nextFrame = NONE_FRAME;

    public void fall(FallingPin pins) throws IllegalAccessException {
        if (first.equals(FallingPin.NONE)) {
            this.first = pins;
            return;
        }
        this.second = pins;

        if (pinCount() > DEFAULT_BOWLING_PIN) {
            throw new IllegalAccessException();
        }
    }

    private int pinCount() {
        return first.value() + second.value();
    }

    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    public boolean isEnd() {
        if (FrameStatus.of(this).equals(STRIKE)) {
            return true;
        }
        return !second.equals(FallingPin.NONE);
    }

    @Override
    public Score getScore() { // 다듬을 여지 있음
        if (Objects.isNull(nextFrame) || !isEnd()) {
            return Score.NOT_DETERMINED;
        }

        Score nextFrameScore = Score.of(0);

        if (FrameStatus.of(this).equals(STRIKE)) {
            if (!nextFrame.isEnd()) {
                return Score.NOT_DETERMINED;
            }
            nextFrameScore = nextFrame.getFallingPinCount();
        }

        if (FrameStatus.of(this).equals(SPARE)) {
            if (nextFrame.isEndFirstTry()) {
                return Score.NOT_DETERMINED;
            }
            nextFrameScore = nextFrame.getFallingPinCountAtFirstTry();
        }

        return getFallingPinCount().add(nextFrameScore);
    }

    private boolean isEndFirstTry() {
        return first.equals(FallingPin.NONE);
    }

    private Score getFallingPinCountAtFirstTry() {
        return Score.of(first.value());
    }

    private Score getFallingPinCount() {
        return Score.of(first.value() + second.value());
    }

    @Override
    public String toString() {
        switch (FrameStatus.of(this)) {
            case STRIKE:
                return "   " + STRIKE.symbol + "   ";

            case SPARE:
                return "  " + first.getSymbol() + "|" + SPARE.symbol + "  ";

            default:
                return "  " + first.getSymbol() + "|" + second.getSymbol() + "  ";
        }
    }

    public enum FrameStatus {
        STRIKE("X"), SPARE("/"), MISS("-"), HIT(""), NONE(" ");

        String symbol;

        FrameStatus(String symbol) {
            this.symbol = symbol;
        }

        public static FrameStatus of(Frame frame) {
            FallingPin first = frame.first;

            if (first.equals(FallingPin.NONE)) {
                return NONE;
            }

            if (first.value() == DEFAULT_BOWLING_PIN) {
                return STRIKE;
            }

            FallingPin second = frame.second;

            if (first.value() + second.value() == DEFAULT_BOWLING_PIN) {
                return SPARE;
            }

            return HIT;
        }
    }
}
