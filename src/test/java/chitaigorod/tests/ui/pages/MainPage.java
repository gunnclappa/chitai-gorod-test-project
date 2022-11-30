package chitaigorod.tests.ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement searchField = $(".search-form__input.js__search-input");
    private final SelenideElement searchButton = $(".chg-icon.chg-icon-search");
    private final SelenideElement basketLink = $(".basket__item-title");
    private final SelenideElement shopsLink = $$(".header-menu__item")
            .findBy(Condition.text("Адреса магазинов"));
    private final SelenideElement souvenirsLink = $$(".nav__item.nav__item_popup")
            .findBy(Condition.text("Сувениры"));


    public final MainPage openPage() {
        open(baseUrl);

        return this;
    }

    public final MainPage searchBook(final String bookName) {
        searchField.click();
        searchField.setValue(bookName);
        searchButton.click();

        return this;
    }

    public final MainPage openShopsPage() {
        shopsLink.click();

        return this;
    }

    public final MainPage openSouvenirsPage() {
        souvenirsLink.click();

        return this;
    }

    public final MainPage openBasketPage() {
        basketLink.click();

        return this;
    }
}
