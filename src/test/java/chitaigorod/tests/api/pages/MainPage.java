package chitaigorod.tests.api.pages;

import chitaigorod.config.AppConfigReader;
import chitaigorod.helpers.ParamsForAPI;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

import java.util.Map;

import static chitaigorod.tests.api.specs.Specification.*;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;

public class MainPage {

    public final MainPage setCookie() {

        open("/ii/img/general/basket.svg");
        Cookie authCookie = new Cookie(AppConfigReader.Instance.read().cookieName(),
                AppConfigReader.Instance.read().cookieValue());
        WebDriverRunner.getWebDriver().manage().addCookie(authCookie);

        return this;
    }

    public final String searchBook(final String bookName) {

        Map<String, String> paramsForSearchBook = ParamsForAPI.paramsForSearchBook(bookName);

        return given()
                .formParams(paramsForSearchBook)
                .when()
                .post("https://search-v2.chitai-gorod.ru/api/v3/search/")
                .then()
                .spec(responseSpec())
                .extract()
                .path("aggregations.titles[0]");
    }

    public final MainPage addBooksToBasket(final String bookId, final int booksCount) {

        Map<String, String> paramsForAddBooksToBasket = ParamsForAPI.paramsForAddBooksToBasket(bookId, booksCount);

        given()
                .spec(requestSpecWebApi())
                .formParams(paramsForAddBooksToBasket)
                .when()
                .get("/basket/")
                .then()
                .spec(responseSpec());

        return this;
    }
}
