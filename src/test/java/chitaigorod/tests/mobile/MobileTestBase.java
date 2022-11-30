package chitaigorod.tests.mobile;

import chitaigorod.tests.TestBase;
import chitaigorod.tests.mobile.pages.WelcomePage;
import chitaigorod.tests.mobile.pages.SearchPage;
import chitaigorod.tests.mobile.pages.MainPage;
import chitaigorod.tests.mobile.pages.BasketPage;
import chitaigorod.tests.mobile.pages.CatalogPage;
import chitaigorod.tests.mobile.pages.ProfilePage;

public class MobileTestBase extends TestBase {

    protected final WelcomePage welcomePage = new WelcomePage();
    protected final SearchPage searchPage = new SearchPage();
    protected final MainPage mainPage = new MainPage();
    protected final BasketPage basketPage = new BasketPage();
    protected final CatalogPage catalogPage = new CatalogPage();
    protected final ProfilePage profilePage = new ProfilePage();
}
