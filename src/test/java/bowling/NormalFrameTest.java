package bowling;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NormalFrameTest {

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
}