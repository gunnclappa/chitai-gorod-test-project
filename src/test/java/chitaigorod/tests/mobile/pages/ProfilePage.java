package chitaigorod.tests.mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static org.assertj.core.api.Assertions.assertThat;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public final class ProfilePage {

    private final SelenideElement location = $(AppiumBy.id("ru.chitaigorod.mobile:id/locationTV"));
    private final SelenideElement city = $$(AppiumBy.id("ru.chitaigorod.mobile:id/textViewGetSubjectTitle"))
            .findBy(Condition.text("Челябинск"));

    public ProfilePage changeLocation() {
        location.click();
        city.click();

        return this;
    }

    public ProfilePage checkLocation(final String value) {
        assertThat(location.text()).isEqualTo(value);

        return this;
    }
}
