package chitaigorod.tests.api.pages;

import chitaigorod.helpers.ParamsForAPI;

import java.util.Map;

import static chitaigorod.tests.api.specs.Specification.requestSpec;
import static chitaigorod.tests.api.specs.Specification.requestSpecWebApi;
import static chitaigorod.tests.api.specs.Specification.responseSpec;
import static io.restassured.RestAssured.given;

public class BookmarksPageAPI {

    public final BookmarksPageAPI addBookToBookmarks(final String bookID) {

        Map<String, String> paramsForAddBookToBookmarks = ParamsForAPI.paramsForAddBookToBookmarks(bookID);

        given()
                .spec(requestSpecWebApi())
                .formParams(paramsForAddBookToBookmarks)
                .when()
                .get("/users/bookmarks/")
                .then()
                .spec(responseSpec());

        return this;
    }

    public final String checkBookInBookmarksPage() {

        return given()
                .spec(requestSpec())
                .when()
                .get("/personal/basket/bookmarks/")
                .htmlPath()
                .getString("**.find{it.@class == 'product-card js_product js__product_card js__slider_item'}"
                        + ".@data-book-id");
    }

    public final BookmarksPageAPI deleteBooksFromBookmarks(final String bookID) {

        Map<String, String> paramsForDeleteBookFromBookmarks = ParamsForAPI.paramsForDeleteBookFromBookmarks(bookID);

        given()
                .spec(requestSpecWebApi())
                .formParams(paramsForDeleteBookFromBookmarks)
                .when()
                .get("/users/bookmarks/")
                .then()
                .spec(responseSpec());

        return this;
    }
}
