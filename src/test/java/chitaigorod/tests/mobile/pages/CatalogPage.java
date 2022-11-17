package chitaigorod.tests.mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public final class CatalogPage {

    private final SelenideElement souvenirs = $(AppiumBy
            .xpath("//android.widget.LinearLayout[@content-desc=\"Сувениры\"]"));
    private final SelenideElement calendars = $$(AppiumBy
            .id("ru.chitaigorod.mobile:id/textViewTitle")).findBy(Condition.text("Календари"));
    private final SelenideElement toolbar = $(AppiumBy.id("ru.chitaigorod.mobile:id/toolbar"))
            .$(AppiumBy.className("android.widget.TextView"));

    public CatalogPage openSouvenirsPage() {
        souvenirs.click();

        return this;
    }

    public CatalogPage openCalendarsPage() {
        calendars.click();

        return this;
    }

    public CatalogPage checkCategory(final String category) {
        toolbar.shouldHave(Condition.text(category));

        return this;
    }
}
