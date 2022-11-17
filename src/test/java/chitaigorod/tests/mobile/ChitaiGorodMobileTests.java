package chitaigorod.tests.mobile;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;

public final class ChitaiGorodMobileTests extends MobileTestBase {

    @BeforeEach
    @DisplayName("Открытие главной страницы")
    public void openMainPage() {

        step("Открытие главной страницы", () -> {
            welcomePage.skip();
        });
    }

    @Tag("MOBILE")
    @Test
    @DisplayName("Поиск книги по названию")
    void searchBookTest() {

        final String bookName = "Death Note";

        step(String.format("Поиск книги %s", bookName), () -> {
            mainPage.search();
            searchPage.search(bookName);
        });

        step(String.format("Проверка отображения книги %s", bookName), () -> {
            searchPage.checkProduct(bookName);
        });
    }

    @Tag("MOBILE")
    @Test
    @DisplayName("Проверка добавления книги в корзину")
    void addBookToBasketTest() {

        final String bookName = "Death Note";

        step(String.format("Поиск книги по названию %s", bookName), () -> {
            mainPage.search();
            searchPage.search(bookName)
                    .checkProduct(bookName);
        });

        step("Добавление книги в корзину", () -> {
            searchPage.addToBasket();
        });

        step("Открытие корзины", () -> {
            WebDriverRunner.getWebDriver().navigate().back();
            mainPage.openBasket();
        });

        step("Проверка книги в корзине", () -> {
            basketPage.checkBookInBasket(bookName);
        });
    }

    @Tag("MOBILE")
    @Test
    @DisplayName("Открытие страницы \"Календари\"")
    void openCalendarsPageTests() {

        final String categoryName = "Календари";

        step(String.format("Открытие страницу %s", categoryName), () -> {
            mainPage.openCatalog();
            catalogPage.openSouvenirsPage();
            catalogPage.openCalendarsPage();
        });

        step(String.format("Проверка открытия страницы %s", categoryName), () -> {
            catalogPage.checkCategory(categoryName);
        });
    }


    @Tag("MOBILE")
    @Test
    @DisplayName("Смена города")
    void changeLocationTest() {

        final String city = "Россия, Челябинск, Челябинская Область";

        step("Смена локации", () -> {
            mainPage.openProfile();
            profilePage.changeLocation();
        });

        step("Проверка локации", () -> {
            profilePage.checkLocation(city);
        });
    }
}
