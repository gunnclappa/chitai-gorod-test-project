package chitaigorod.tests.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public final class AddBookToBasketTest extends UITestBase {

    @Test
    @DisplayName("Проверка добавления книги в корзину")
    void addBookToBasketTest() {

        final String bookName = "Death Note";
        final String buyText = "Купить";

        step(String.format("Поиск книги %s", bookName), () -> {
            mainPage.searchBook(bookName);

            step(String.format("Проверка отображения книги %s", bookName), () ->
                    searchPage.checkIfBookIsFound(bookName));
        });

        step(String.format("Нажать на кнопку %s", buyText), () ->
                searchPage.clickBuyButton(buyText));

        step("Открыть корзину", () ->
                mainPage.clickBasketButton());

        step(String.format("Проверка отображения книги %s в корзине", bookName), () ->
                basketPage.checkBookInBasket(bookName));
    }
}
