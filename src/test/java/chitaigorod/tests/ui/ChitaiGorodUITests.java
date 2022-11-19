package chitaigorod.tests.ui;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Configuration.baseUrl;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public final class ChitaiGorodUITests extends UITestBase {

    @BeforeEach
    @DisplayName("Открытие главной страницы")
    public void openCheckPage(final TestInfo info) {

        if (info.getDisplayName().equals("Проверка отображения инфо-текста на странице Закладки")) {
            return;
        }

        step(String.format("Открытие страницы %s", baseUrl), () -> {
            mainPage.openPage();
        });
    }

    @Tag("UI")
    @ValueSource(strings = {"Death Note", "Dead Guilty", "The Art of War"})
    @ParameterizedTest(name = "Поиск книги по названию {0}")
    void searchBookTest(final String bookName) {

        step(String.format("Поиск книги %s", bookName), () -> {
            mainPage.searchBook(bookName);
        });

        step(String.format("Проверка отображения книги %s", bookName), () -> {
            searchPage.checkIfBookExist(bookName);
        });
    }

    @Tag("UI")
    @ValueSource(strings = {"Магнитогорск", "Москва", "Новосибирск"})
    @ParameterizedTest(name = "Открытие страницы с адресами магазинов для города {0}")
    void openShopsTests(final String cityName) {

        step("Открыть страницу \"Наши магазины\"", () -> {
            mainPage.openShopsPage();
        });

        step(String.format("Поиск города %s", cityName), () -> {
            shopsPage.cityLinkClick(cityName);
        });

        step(String.format("Проверка открытия страницы с городом %s", cityName), () -> {
            shopsPage.checkCity(cityName);
        });
    }

    @Tag("UI")
    @Test
    @DisplayName("Открытие страницы \"Календари\"")
    void openCalendarsPageTests() {

        final String categoryName = "Календари";

        step(String.format("Открытие страницу %s", categoryName), () -> {
            mainPage.openSouvenirsPage();
            catalogPage.openCalendarsPage();
        });

        step(String.format("Проверка открытия страницы %s", categoryName), () -> {
            catalogPage.checkCategory(categoryName);
        });
    }

    @Tag("UI")
    @Test
    @DisplayName("Проверка перехода в корзину при нажатии \"Купить\" → \"Оформить\"")
    void popularCitiesTest() {

        final String bookName = "death note";
        final String buyText = "Купить";
        final String purchaseText = "Оформить";
        final String basketUrl = baseUrl + "personal/basket/";

        step(String.format("Поиск книги %s", bookName), () -> {
            mainPage.searchBook(bookName);

            step(String.format("Проверка отображения книги %s", bookName), () -> {
                searchPage.checkIfBookExist(bookName);
            });
        });

        step(String.format("Нажать на кнопку %s", buyText), () -> {
            searchPage.buyButtonClick(buyText);
        });

        step(String.format("Проверка смены текста на кнопке на %s", purchaseText), () -> {
            searchPage.checkIfTextChanged(purchaseText);
        });

        step(String.format("Нажать на кнопку %s", purchaseText), () -> {
            searchPage.purchaseButtonClick();
        });

        step(("Проверка открытия корзины"), () -> {
            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            assertThat(currentUrl).isEqualTo(basketUrl);
        });
    }

    @Tag("UI")
    @Test
    @DisplayName("Проверка добавления книги в корзину")
    void addBookToBasketTest() {

        final String bookName = "Death Note";
        final String buyText = "Купить";

        step(String.format("Поиск книги %s", bookName), () -> {
            mainPage.searchBook(bookName);

            step(String.format("Проверка отображения книги %s", bookName), () -> {
                searchPage.checkIfBookExist(bookName);
            });
        });

        step(String.format("Нажать на кнопку %s", buyText), () -> {
            searchPage.buyButtonClick(buyText);
        });

        step("Открыть корзину", () -> {
            mainPage.openBasketPage();
        });

        step(String.format("Проверка отображения книги %s в корзине", bookName), () -> {
            basketPage.checkBookInBasket(bookName);
        });
    }
}
