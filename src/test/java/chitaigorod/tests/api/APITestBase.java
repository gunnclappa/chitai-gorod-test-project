package chitaigorod.tests.api;

import chitaigorod.tests.api.pages.BasketPageAPI;
import chitaigorod.tests.api.pages.BookmarksPageAPI;
import chitaigorod.tests.api.pages.MainPageAPI;
import chitaigorod.tests.api.pages.PersonalPageAPI;
import org.junit.jupiter.api.Tag;

@Tag("API")
public class APITestBase {

    protected final MainPageAPI mainPageAPI = new MainPageAPI();
    protected final PersonalPageAPI personalPage = new PersonalPageAPI();
    protected final BookmarksPageAPI bookmarksAPI = new BookmarksPageAPI();
    protected final BasketPageAPI basketAPI = new BasketPageAPI();
}
