package domain;

import output.BollingScorePresentable;

public class Frame implements Scorable {

    public final static int DEFAULT_BOLLING_PIN = 10;

    private FallingPin first = FallingPin.NONE;
    private FallingPin second = FallingPin.NONE;

    public Frame(FallingPin first, FallingPin second) {
        this.first = first;
        this.second = second;
    }

    public FrameStatus getStatus() {
        if (first.value() == DEFAULT_BOLLING_PIN) {
            return FrameStatus.STRIKE;
        }

        if (first.value() + second.value() == DEFAULT_BOLLING_PIN) {
            return FrameStatus.SPARE;
        }

        if (first.value() + second.value() == 0) {
            return FrameStatus.MISS;
        }

        return FrameStatus.SPARE;
    }

    @Override
    public Score getScore() {
        // some way of calculate score
        return Score.ZERO_SCORE;
    }

    public void print(BollingScorePresentable pinter) {
        pinter.show(this);
    }

    public FallingPin getFirst() {
        return first;
    }

    public FallingPin getSecond() {
        return second;
    }
}
