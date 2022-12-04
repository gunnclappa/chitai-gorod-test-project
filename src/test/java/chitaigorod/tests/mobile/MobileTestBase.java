package chitaigorod.tests.mobile;

import chitaigorod.drivers.BrowserstackMobileDriver;
import chitaigorod.drivers.LocalMobileDriver;
import chitaigorod.tests.TestBase;
import chitaigorod.helpers.AllureAttachments;
import chitaigorod.helpers.DriverUtils;
import chitaigorod.tests.mobile.pages.WelcomePage;
import chitaigorod.tests.mobile.pages.SearchPage;
import chitaigorod.tests.mobile.pages.MainPage;
import chitaigorod.tests.mobile.pages.BasketPage;
import chitaigorod.tests.mobile.pages.CatalogPage;
import chitaigorod.tests.mobile.pages.ProfilePage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Configuration.browser;
import static io.qameta.allure.Allure.step;

@Tag("mobile")
public class MobileTestBase extends TestBase {

    protected final WelcomePage welcomePage = new WelcomePage();
    protected final SearchPage searchPage = new SearchPage();
    protected final MainPage mainPage = new MainPage();
    protected final BasketPage basketPage = new BasketPage();
    protected final CatalogPage catalogPage = new CatalogPage();
    protected final ProfilePage profilePage = new ProfilePage();

    @BeforeEach
    public final void openMainPage() {

        step("Открытие главной страницы", () -> {
            welcomePage.skip();
        });
    }

    public static void mobilePlatform(final String env) throws Exception {

        switch (env) {
            case "browserstack":
                browser = BrowserstackMobileDriver.class.getName();
                break;
            case "local":
            case "real":
                browser = LocalMobileDriver.class.getName();
                break;
            default:
                throw new Exception("Wrong env");
        }
    }

    @AfterEach
    public final void afterEachMobile() {

        String sessionId = DriverUtils.getSessionId();
        Selenide.closeWebDriver();

        if (System.getProperty("env").equals("browserstack")) {
            AllureAttachments.addVideoBrowserstack(sessionId);
        }
    }
}
