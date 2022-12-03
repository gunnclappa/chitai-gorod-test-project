package chitaigorod.tests.api.pages;

import chitaigorod.helpers.ParamsForAPI;

import java.util.Map;

import static chitaigorod.tests.api.specs.Specification.requestSpec;
import static chitaigorod.tests.api.specs.Specification.requestSpecWebApi;
import static chitaigorod.tests.api.specs.Specification.responseSpec;
import static io.restassured.RestAssured.given;

public class BasketPageAPI {

    public final int booksInBasketCount() {

        return given()
                .spec(requestSpec())
                .when()
                .get("/personal/basket/")
                .htmlPath()
                .getInt("**.find{it.@class == 'item-counter__value js__item-counter__value'}.@value");
    }

    public final BasketPageAPI deleteBooksFromBasket(final String bookId) {

        Map<String, String> paramsForDeleteBooksFromBasket = ParamsForAPI.paramsForDeleteBooksFromBasket(bookId);

        given()
                .spec(requestSpecWebApi())
                .formParams(paramsForDeleteBooksFromBasket)
                .when()
                .get("/basket/")
                .then()
                .spec(responseSpec());

        return this;
    }
}
