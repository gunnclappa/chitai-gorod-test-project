package chitaigorod.tests.mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public final class BasketPage {

    private final SelenideElement book = $(AppiumBy.id("ru.chitaigorod.mobile:id/textViewCartProductTitle"));

    public BasketPage checkBookInBasket(final String value) {
        book.shouldHave(Condition.text(value));

        return this;
    }
}
