package chitaigorod.tests.mobile;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AddBookToBasketTest extends MobileTestBase {

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
            mainPage.clickBasketButton();
        });

        step("Проверка книги в корзине", () -> {
            basketPage.checkBookInBasket(bookName);
        });
    }
}
