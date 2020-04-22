package user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {

    @ParameterizedTest
    @DisplayName("사용자의 이름을 입력하고 조회할 수 있다")
    @ValueSource(strings = {"Nesoy", "nesoy kwon"})
    public void test(String name) {
        User user = new User(name);

        assertThat(user.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @DisplayName("사용자의 이름이 잘못된 경우 에러를 반환한다.")
    @NullAndEmptySource
    public void test2(String name) {
        Exception exception = assertThrows(InvalidParameterException.class, () -> new User(name));

        assertThat(exception).hasMessageContaining("required valid name");
    }

}
