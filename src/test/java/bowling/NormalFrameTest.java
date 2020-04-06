package bowling;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NormalFrameTest {
    private NormalFrame frame;

    @BeforeEach
    public void setUp(){
        frame = new NormalFrame(1);
    }

    @ParameterizedTest
    @DisplayName("Frame은 프레임 정보(현재 프레임 순서)에 대한 책임을 가지고 있다.")
    @ValueSource(longs = {1, 2, 3})
    public void test(long validFrameNo) {
        NormalFrame frame = new NormalFrame(validFrameNo);

        assertThat(frame.getFrameNo()).isEqualTo(validFrameNo);
    }

    @ParameterizedTest
    @DisplayName("Frame은 잘못된 프레임 정보(현재 프레임 순서)에 대해 예외를 반환할 책임을 가지고 있다.")
    @ValueSource(longs = {-1, 0})
    public void test2(long invalidFrameNo) {
        Exception exception = assertThrows(InvalidParameterException.class, () -> new NormalFrame(invalidFrameNo));

        assertThat(exception).hasMessageContaining("required valid frame no");
    }

    @DisplayName("Frame은 쓰러진 핀의 개수를 통해 하나의 볼링 점수를 계산할 책임을 가지고 있다.")
    @Nested
    class FrameScore {
        @Test
        @DisplayName("Strike")
        public void test_strike() {
            frame.throwBowling(10);

            assertThat(frame.getScore()).isEqualTo(ScoreType.Strike);
        }

        @Test
        @DisplayName("Spare")
        public void test_spare() {
            frame.throwBowling(8);
            frame.throwBowling(2);

            assertThat(frame.getScore()).isEqualTo(ScoreType.Spare);
        }

        @Test
        @DisplayName("Gutter")
        public void test_gutter() {
            frame.throwBowling(0);
            frame.throwBowling(0);

            assertThat(frame.getScore()).isEqualTo(ScoreType.Gutter);
        }

        @Test
        @DisplayName("Miss")
        public void test_miss() {
            frame.throwBowling(2);
            frame.throwBowling(4);

            assertThat(frame.getScore()).isEqualTo(ScoreType.Miss);
        }

        @Test
        @DisplayName("잘못 입력되는 경우")
        public void test_invalid_score() {
            Exception exception = assertThrows(InvalidParameterException.class, () -> frame.throwBowling(-1));

            assertThat(exception).hasMessageContaining("required valid droppedPins");
        }
    }
}