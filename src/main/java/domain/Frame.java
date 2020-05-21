package domain;

import static domain.Frame.FrameStatus.*;

public class Frame implements Scorable {
    public final static int DEFAULT_BOWLING_PIN = 10;
    public final static Frame NONE_FRAME = new Frame(null);

    private FallingPin first = FallingPin.NONE;
    private FallingPin second = FallingPin.NONE;

    private Frame previousFrame;

    /*public Frame() {
        this.previousFrame = this;
    }*/

    public Frame(Frame previousFrame) {
        this.previousFrame = previousFrame;
    }

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

    @Override
    public Score getScore() {
        if (previousFrame.isSpareOrStrike()) {
            return Score.NOT_DETERMINED;
        }

        if (previousFrame.equals(this)) {
            return Score.ZERO;
        }

        Score previousScore = previousFrame.getScore();
        return Score.of(pinCount() + previousScore.value());
    }

    private boolean isSpareOrStrike() {
        return (FrameStatus.of(this).equals(STRIKE)) || (FrameStatus.of(this).equals(SPARE));
    }

    public boolean isEnd() {
        if (FrameStatus.of(this).equals(STRIKE)) {
            return true;
        }
        return second != FallingPin.NONE;
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

    @Override
    public String toString() {
        switch (FrameStatus.of(this)) {
            case STRIKE:
                return "   " + STRIKE.symbol + " ";

            case SPARE:
                return first.getSymbol() + "|" + SPARE.symbol;

            default:
                return first.getSymbol() + "|" + second.getSymbol();
        }
    }
}
