package chitaigorod.tests.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ShopsPage {

    private final SelenideElement headerText = $(".color_blue");

    public final ShopsPage cityLinkClick(final String cityName) {
        final SelenideElement cityLink = $(byText(cityName));
        cityLink.click();

        return this;
    }

    public final ShopsPage checkCity(final String cityName) {
        headerText.shouldHave(Condition.text(cityName));

        return this;
    }
}
