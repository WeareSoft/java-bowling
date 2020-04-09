package bowling.score;

class UnitScore {
    private long score;

    public UnitScore(long droppedPins) {
        this.score = droppedPins;
    }

    public long getScore() {
        return this.score;
    }
}
