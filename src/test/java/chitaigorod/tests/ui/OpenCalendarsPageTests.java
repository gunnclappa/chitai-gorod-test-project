package chitaigorod.tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public final class OpenCalendarsPageTests extends UITestBase {

    @Test
    @DisplayName("Открытие страницы \"Календари\"")
    void openCalendarsPageTests() {

        final String categoryName = "Календари";

        step(String.format("Открытие страницу %s", categoryName), () -> {
            mainPage.clickSouvenirsButton();
            catalogPage.clickCalendarsButton();
        });

        step(String.format("Проверка открытия страницы %s", categoryName), () ->
                catalogPage.checkCategory(categoryName));
    }
}
