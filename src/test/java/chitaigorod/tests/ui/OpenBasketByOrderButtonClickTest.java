package chitaigorod.tests.ui;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public final class OpenBasketByOrderButtonClickTest extends UITestBase {

    @Test
    @DisplayName("Проверка перехода в корзину при нажатии \"Купить\" → \"Оформить\"")
    void openBasketByOrderButtonClickTest() {

        final String bookName = "death note";
        final String buyText = "Купить";
        final String purchaseText = "Оформить";
        final String basketUrl = baseUrl + "personal/basket/";

        step(String.format("Поиск книги %s", bookName), () -> {
            mainPage.searchBook(bookName);

            step(String.format("Проверка отображения книги %s", bookName), () ->
                    searchPage.checkIfBookIsFound(bookName));
        });

        step(String.format("Нажать на кнопку %s", buyText), () ->
                searchPage.clickBuyButton(buyText));

        step(String.format("Проверка смены текста на кнопке на %s", purchaseText), () ->
                searchPage.checkIfTextIsChanged(purchaseText));

        step(String.format("Нажать на кнопку %s", purchaseText), () ->
                searchPage.clickPurchaseButton());

        step(("Проверка открытия корзины"), () -> {
            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            assertThat(currentUrl).isEqualTo(basketUrl);
        });
    }

}
