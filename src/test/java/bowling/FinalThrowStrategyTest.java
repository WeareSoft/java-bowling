package bowling;

import static org.assertj.core.api.Assertions.assertThat;

import bowling.score.FrameScore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FinalThrowStrategyTest {

    @Test
    @DisplayName("마지막 프레임은 2번 내의 모두 쓰러트린 경우 한번 더 던질 수 있다")
    public void final_frame() {
        BowlingThrowStrategy strategy = new FinalThrowStrategy();
        FrameScore frameScore = new FrameScore();
        frameScore.addScore(2);
        frameScore.addScore(8);

        assertThat(strategy.isPossibleThrowing(frameScore)).isTrue();
    }
}