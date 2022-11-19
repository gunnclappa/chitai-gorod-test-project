package chitaigorod.tests.api;

import chitaigorod.tests.api.pages.BasketPage;
import chitaigorod.tests.api.pages.BookmarksPage;
import chitaigorod.tests.api.pages.MainPage;
import chitaigorod.tests.api.pages.PersonalPage;

public class APITestBase {

    protected final MainPage mainPage = new MainPage();
    protected final PersonalPage personalPage = new PersonalPage();
    protected final BookmarksPage bookmarksPage = new BookmarksPage();
    protected final BasketPage basketPage = new BasketPage();
}
