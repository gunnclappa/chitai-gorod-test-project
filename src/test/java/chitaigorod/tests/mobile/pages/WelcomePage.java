package chitaigorod.tests.mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class WelcomePage {

    private final SelenideElement nextButton = $(AppiumBy.id("ru.chitaigorod.mobile:id/buttonNext"));
    private final SelenideElement continueButton = $(AppiumBy.id("ru.chitaigorod.mobile:id/buttonProceed"));
    private final SelenideElement notNowButton = $(AppiumBy.id("ru.chitaigorod.mobile:id/buttonNotNow"));

    public final WelcomePage skip() {
        sleep(5000);
        nextButton.click();
        nextButton.click();
        nextButton.click();
        nextButton.click();
        continueButton.click();
        notNowButton.click();

        return this;
    }
}
