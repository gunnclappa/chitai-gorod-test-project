package chitaigorod.tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ChangeLocationTest extends MobileTestBase {

    @Test
    @DisplayName("Смена города")
    void changeLocationTest() {

        final String city = "Челябинск";

        step("Смена локации", () -> {
            mainPage.clickProfileButton();
            profilePage.changeLocation(city);
        });

        step("Проверка локации", () -> {
            profilePage.checkLocation(city);
        });
    }
}
