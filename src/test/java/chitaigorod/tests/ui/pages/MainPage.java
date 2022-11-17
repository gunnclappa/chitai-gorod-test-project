package chitaigorod.tests.ui.pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement searchField = $(".search-form__input.js__search-input");
    private final SelenideElement searchButton = $(".chg-icon.chg-icon-search");
    private final SelenideElement bookmarksLink = $(".bookmarks");
    private final SelenideElement shopsLink = $$(".header-menu__item")
            .findBy(Condition.text("Адреса магазинов"));
    private final SelenideElement souvenirsLink = $$(".nav__item.nav__item_popup")
            .findBy(Condition.text("Сувениры"));
    //private final ElementsCollection books = $$(".product-card");

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

    public final MainPage openBookmarksPage() {
        bookmarksLink.click();

        return this;
    }
}
