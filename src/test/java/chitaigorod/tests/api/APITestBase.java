package chitaigorod.tests.api;

import chitaigorod.tests.api.pages.BasketPage;
import chitaigorod.tests.api.pages.BookmarksPageAPI;
import chitaigorod.tests.api.pages.MainPage;
import chitaigorod.tests.api.pages.PersonalPage;

public class APITestBase {

    protected final MainPage mainPage = new MainPage();
    protected final PersonalPage personalPage = new PersonalPage();
    protected final BookmarksPageAPI bookmarksPage = new BookmarksPageAPI();
    protected final BasketPage basketPage = new BasketPage();
}
