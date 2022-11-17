package chitaigorod.tests.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CatalogPage {

    private final SelenideElement headerText = $(".color_blue");
    private final SelenideElement calendarsLink = $$("a.navigation__link").findBy(Condition.text("Календари"));

    public final CatalogPage openCalendarsPage() {
        calendarsLink.click();

        return this;
    }

    public final CatalogPage checkCategory(final String categoryName) {
        headerText.shouldHave(Condition.text(categoryName));

        return this;
    }

    public final CatalogPage hideNotification() {
        executeJavaScript(
                "$('#push-notification-balloon').hide();"
        );

        return this;
    }
}
