package chitaigorod.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import static chitaigorod.tests.mobile.MobileTestBase.mobilePlatform;
import static chitaigorod.tests.ui.UITestBase.uiPlatform;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    static final String TAG = System.getProperty("tag");
    static final String ENV = System.getProperty("env");

    @BeforeAll
    static void beforeAll() throws Exception {
        selectDriver();
    }

    private static void selectDriver() throws Exception {
        switch (TAG) {
            case "api":
                break;
            case "mobile":
                mobilePlatform(ENV);
                break;
            case "ui":
                uiPlatform(ENV);
                break;
            default:
                throw new Exception("Wrong platform");
        }
    }

    @BeforeEach
    public final void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        open();
    }
}
