package bowling.score;

import java.util.ArrayList;
import java.util.List;

public class FrameScore {

    private List<UnitScore> scores;

    public FrameScore() {
        this.scores = new ArrayList<>();
    }

    public void addScore(long droppedPins){
        scores.add(new UnitScore(droppedPins));
    }

    public long getTotalScore() {
        return scores.stream().mapToLong(UnitScore::getScore).sum();
    }

    public long getCount() {
        return scores.size();
    }
}
