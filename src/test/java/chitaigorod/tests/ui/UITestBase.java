package chitaigorod.tests.ui;

import chitaigorod.tests.TestBase;
import chitaigorod.tests.ui.pages.*;

public class UITestBase extends TestBase {

    protected final MainPage mainPage = new MainPage();
    protected final SearchPage searchPage = new SearchPage();
    protected final ShopsPage shopsPage = new ShopsPage();
    protected final CatalogPage catalogPage = new CatalogPage();
    protected final BasketPage basketPage = new BasketPage();
}
