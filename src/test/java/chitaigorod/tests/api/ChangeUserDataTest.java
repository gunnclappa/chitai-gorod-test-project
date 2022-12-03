package chitaigorod.tests.api;

import chitaigorod.tests.api.models.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static chitaigorod.tests.api.models.TestUser.createRandomUser;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public final class ChangeUserDataTest extends APITestBase {

    @MethodSource("changeUserDataTest")
    @ParameterizedTest(name = "Проверка смены личных данных пользователя")
    void changeUserDataTest(final User user) {

        step("Смена личных данных пользователя", () -> {
            personalPage.changePersonalData(user);
        });

        step("Проверка успешности смены личных данных", () -> {
            Map<String, String> userData = personalPage.checkPersonalData();

            assertThat(userData.get("surname")).isEqualTo(user.getSurname());
            assertThat(userData.get("name")).isEqualTo(user.getName());
            assertThat(userData.get("secondName")).isEqualTo(user.getSecondName());
        });
    }

    static Stream<Arguments> changeUserDataTest() {
        return Stream.of(
                Arguments.of(createRandomUser()),
                Arguments.of(createRandomUser()),
                Arguments.of(createRandomUser())
        );
    }
}
