package bowling.score;

import bowling.ScoreType;
import java.util.ArrayList;
import java.util.List;

public class FrameScore {

    private List<UnitScore> scores;

    public FrameScore() {
        this.scores = new ArrayList<>();
    }

    public void addScore(long droppedPins) {
        scores.add(new UnitScore(droppedPins));
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
}
