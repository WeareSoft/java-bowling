package bowling;

import bowling.score.FrameScore;
import java.util.function.Predicate;
import java.util.stream.Stream;

public enum ScoreType {
    Strike(1, (score) -> score == 10),
    Spare(2, (score) -> score == 10),
    Miss(2, (score) -> score < 10 && score > 0),
    Gutter(2, (score) -> score == 0),
    NONE(-1, (score) -> score < 0);

    private long count;
    private Predicate<Long> score;

    ScoreType(long count, Predicate<Long> score) {
        this.count = count;
        this.score = score;
    }

    public static ScoreType getScoreType(FrameScore frameScore) {
        return Stream.of(ScoreType.values())
                .filter(type -> type.count == frameScore.getCount())
                .filter(type -> type.score.test(frameScore.getTotalScore()))
                .findFirst().orElse(NONE);
    }
}
