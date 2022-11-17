package chitaigorod.tests.mobile;

import chitaigorod.tests.TestBase;
import chitaigorod.tests.mobile.pages.*;

public class MobileTestBase extends TestBase {

    protected final WelcomePage welcomePage = new WelcomePage();
    protected final SearchPage searchPage = new SearchPage();
    protected final MainPage mainPage = new MainPage();
    protected final BasketPage basketPage = new BasketPage();
    protected final CatalogPage catalogPage = new CatalogPage();
    protected final ProfilePage profilePage = new ProfilePage();
}
