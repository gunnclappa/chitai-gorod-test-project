package chitaigorod.tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class OpenCalendarsPageTests extends MobileTestBase {

    @Test
    @DisplayName("Открытие страницы \"Календари\"")
    void openCalendarsPageTests() {

        final String categoryName = "Календари";

        step(String.format("Открытие страницу %s", categoryName), () -> {
            mainPage.clickCatalogButton();
            catalogPage.clickSouvenirsPage();
            catalogPage.clickCalendarsPage();
        });

        step(String.format("Проверка открытия страницы %s", categoryName), () -> {
            catalogPage.checkCategory(categoryName);
        });
    }
}
