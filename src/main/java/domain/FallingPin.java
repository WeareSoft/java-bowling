package domain;

public class FallingPin {
    public final static FallingPin MISS = new FallingPin(0);
    public final static FallingPin NONE = new FallingPin(-1);
    private int fallingPinCount;

    public FallingPin(int fallingPinCount) {
        if(fallingPinCount > Frame.DEFAULT_BOWLING_PIN) {
            throw new IllegalArgumentException("10개 이하");
        }
        this.fallingPinCount = fallingPinCount;
    }

    public int value() {
        return fallingPinCount;
    }

    public  String getSymbol() {
        if (this.equals(MISS)) {
            return Frame.FrameStatus.MISS.symbol;
        }
        return String.valueOf(fallingPinCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FallingPin that = (FallingPin) o;

        return fallingPinCount == that.fallingPinCount;

    }

    @Override
    public int hashCode() {
        return fallingPinCount;
    }
}
