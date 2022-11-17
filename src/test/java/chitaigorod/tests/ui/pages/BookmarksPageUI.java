package chitaigorod.tests.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BookmarksPageUI {

    private final SelenideElement bookmarksInfoBlock = $(".bookmarks-info-block");

    public final BookmarksPageUI checkInfoBlock(final String infoBlockText) {
        bookmarksInfoBlock.shouldHave(Condition.text(infoBlockText));

        return this;
    }
}
