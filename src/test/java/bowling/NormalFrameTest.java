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
    public void setUp() {
        frame = new NormalFrame(1, new NormalThrowStrategy());
    }

    @ParameterizedTest
    @DisplayName("Frame은 프레임 정보(현재 프레임 순서)에 대한 책임을 가지고 있다.")
    @ValueSource(longs = {1, 2, 3})
    public void test(long validFrameNo) {
        NormalFrame frame = new NormalFrame(validFrameNo, new NormalThrowStrategy());

        assertThat(frame.getFrameNo()).isEqualTo(validFrameNo);
    }

    @ParameterizedTest
    @DisplayName("Frame은 잘못된 프레임 정보(현재 프레임 순서)에 대해 예외를 반환할 책임을 가지고 있다.")
    @ValueSource(longs = {-1, 0})
    public void test2(long invalidFrameNo) {
        Exception exception = assertThrows(InvalidParameterException.class, () -> new NormalFrame(invalidFrameNo, new NormalThrowStrategy()));

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

        @Test
        @DisplayName("특정 횟수 이상으로 던져도 같은 결과를 반환한다")
        public void test_repeat() {
            frame.throwBowling(10);
            frame.throwBowling(10);

            assertThat(frame.getScore()).isEqualTo(ScoreType.Strike);
        }

        @Test
        @DisplayName("던진 순서대로 결과과 결정된다")
        public void test_repeat2() {
            frame.throwBowling(5);
            frame.throwBowling(4);
            frame.throwBowling(3);
            frame.throwBowling(3);

            assertThat(frame.getScore()).isEqualTo(ScoreType.Miss);
        }

        @Test
        @DisplayName("던진 순서대로 결과과 결정된다")
        public void test_repeat3() {
            frame.throwBowling(0);
            frame.throwBowling(0);
            frame.throwBowling(10);

            assertThat(frame.getScore()).isEqualTo(ScoreType.Gutter);
        }
    }

    @Test
    @DisplayName("프레임이 종료가 되면 다음 프레임을 생성할 책임이 있다")
    public void make_frame() {
        assertThat(frame.getNextFrame()).isNull();

        frame.throwBowling(10);

        assertThat(frame.getNextFrame()).isNotNull();
    }

    @Test
    @DisplayName("최대 프레임까지 생성이 되면 생성을 종료할 책임이 있다")
    public void make_final_frame() {
        assertThat(frame.getNextFrame()).isNull();

        NormalFrame next = frame;
        do {
            next.throwBowling(10);
            next = next.getNextFrame();
        } while (next.getFrameNo() != NormalFrame.FINAL_FRAME_NO);

        assertThat(next.getNextFrame()).isNull();
        assertThat(next.getFrameNo()).isEqualTo(NormalFrame.FINAL_FRAME_NO);
    }
}