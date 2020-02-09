package domain;

import output.BollingScorePresentable;

public class FallingPin {
    public final static FallingPin MISS = new FallingPin(0);
    public final static FallingPin NONE = new FallingPin(-1);
    private int fallingPinCount;

    public FallingPin(int fallingPinCount) {
        if(fallingPinCount > Frame.DEFAULT_BOLLING_PIN) {
            throw new IllegalArgumentException("10개 이하");
        }
        this.fallingPinCount = fallingPinCount;
    }

    public int value() {
        return fallingPinCount;
    }

    public void print(BollingScorePresentable printer) {
        printer.show(this);
    }
}
