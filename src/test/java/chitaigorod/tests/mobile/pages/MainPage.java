package chitaigorod.tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement searchField = $(AppiumBy.id("ru.chitaigorod.mobile:id/frameLayoutSearch"));
    private final SelenideElement catalog = $(AppiumBy
            .xpath("//android.widget.FrameLayout[@content-desc=\"Каталог\"]"));
    private final SelenideElement basket = $(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Корзина\"]"));
    private final SelenideElement profile = $(AppiumBy
            .xpath("//android.widget.FrameLayout[@content-desc=\"Профиль\"]"));

    public final MainPage search() {
        searchField.click();

        return this;
    }

    public final MainPage openBasket() {
        basket.click();

        return this;
    }

    public final MainPage openCatalog() {
        catalog.click();

        return this;
    }

    public final MainPage openProfile() {
        profile.click();

        return this;
    }
}
