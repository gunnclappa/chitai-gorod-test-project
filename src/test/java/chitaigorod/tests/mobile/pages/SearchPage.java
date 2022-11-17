package chitaigorod.tests.mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public final class SearchPage {

    private final SelenideElement searchField2 = $(AppiumBy.id("ru.chitaigorod.mobile:id/search_src_text"));
    private final SelenideElement productTitle = $(AppiumBy.id("ru.chitaigorod.mobile:id/textViewProductTitle"));
    private final SelenideElement buyButton = $(AppiumBy.id("ru.chitaigorod.mobile:id/buttonAction"));

    public SearchPage search(final String value) {
        searchField2.sendKeys(value);
        WebDriverRunner.getWebDriver().navigate().back();

        return this;
    }

    public SearchPage checkProduct(final String value) {
        productTitle.shouldHave(Condition.text(value));

        return this;
    }

    public SearchPage addToBasket() {
        buyButton.click();

        return this;
    }
}
