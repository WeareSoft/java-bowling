package bowling.score;

import bowling.BowlingThrowStrategy;
import bowling.ScoreType;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class FrameScore {

    private static final int MIN_PINS = 0;

    private List<UnitScore> scores;
    private BowlingThrowStrategy strategy;

    public FrameScore(BowlingThrowStrategy bowlingThrowStrategy) {
        this.scores = new ArrayList<>();
        this.strategy = bowlingThrowStrategy;
    }

    public void addScore(long droppedPins) {
        if (droppedPins < MIN_PINS) {
            throw new InvalidParameterException("required valid droppedPins");
        }

        if (isPossibleThrowing()) {
            scores.add(new UnitScore(droppedPins));
        }
    }

    public long getPartScore(int start, int endExclusive) {
        return scores.subList(start, endExclusive).stream().mapToLong(UnitScore::getScore).sum();
    }

    public long getTotalScore() {
        return scores.stream().mapToLong(UnitScore::getScore).sum();
    }

    public long getCount() {
        return scores.size();
    }

    public List<UnitScore> getScores() {
        return scores;
    }

    public ScoreType getScoreType() {
        return ScoreType.getScoreType(this);
    }

    public boolean isPossibleThrowing() {
        return strategy.isPossibleThrowing(this);
    }
}
