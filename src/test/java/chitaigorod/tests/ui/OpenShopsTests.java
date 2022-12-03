package chitaigorod.tests.ui;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public final class OpenShopsTests extends UITestBase {

    @ValueSource(strings = {"Магнитогорск", "Москва", "Новосибирск"})
    @ParameterizedTest(name = "Открытие страницы с адресами магазинов для города {0}")
    void openShopsTests(final String cityName) {

        step("Открыть страницу \"Наши магазины\"", () ->
                mainPage.clickShopsButton());

        step(String.format("Поиск города %s", cityName), () ->
                shopsPage.clickCityLink(cityName));

        step(String.format("Проверка открытия страницы с городом %s", cityName), () ->
                shopsPage.checkCity(cityName));
    }
}
