package chitaigorod.tests.ui;

import chitaigorod.config.WebConfig;
import chitaigorod.config.WebConfigReader;
import chitaigorod.drivers.LocalAndRemoteWebDriver;
import chitaigorod.tests.TestBase;
import chitaigorod.helpers.AllureAttachments;
import chitaigorod.helpers.DriverUtils;
import chitaigorod.tests.ui.pages.MainPage;
import chitaigorod.tests.ui.pages.SearchPage;
import chitaigorod.tests.ui.pages.ShopsPage;
import chitaigorod.tests.ui.pages.CatalogPage;
import chitaigorod.tests.ui.pages.BasketPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;

import java.util.Objects;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static io.qameta.allure.Allure.step;

@Tag("ui")
public class UITestBase extends TestBase {

    private static final WebConfig WEB_CONFIG = WebConfigReader.Instance.read();

    protected final MainPage mainPage = new MainPage();
    protected final SearchPage searchPage = new SearchPage();
    protected final ShopsPage shopsPage = new ShopsPage();
    protected final CatalogPage catalogPage = new CatalogPage();
    protected final BasketPage basketPage = new BasketPage();

    @BeforeEach
    public final void openMainPage() {

        step(String.format("Открытие страницы %s", baseUrl), () ->
                mainPage.open());
    }

    public static void uiPlatform(final String env) throws Exception {
        if (env.equals("remote") || env.equals("local")) {
            LocalAndRemoteWebDriver projectConfiguration = new LocalAndRemoteWebDriver(WEB_CONFIG);
            projectConfiguration.projectConfig();
        } else {
            throw new Exception("Wrong env");
        }
    }

    @AfterEach
    public final void afterEachUI() {

        String sessionId = DriverUtils.getSessionId();

        if (Objects.equals(browser, "chrome")) {
            AllureAttachments.addBrowserConsoleLogs();
        }

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        Selenide.closeWebDriver();
        AllureAttachments.addVideo(sessionId);
    }
}
