package chitaigorod.helpers;

import chitaigorod.tests.api.models.User;

import java.util.HashMap;
import java.util.Map;

public class ParamsForAPI {

    public static Map<String, String> paramsForSearchBook(final String bookName) {

        Map<String, String> params = new HashMap<>();
        params.put("index", "goods");
        params.put("query", bookName);
        params.put("type", "common");
        params.put("from", "0");
        params.put("per_page", "24");
        params.put("filters[available]", "false");

        return params;
    }

    public static Map<String, String> paramsForAddBooksToBasket(final String bookId, final int booksCount) {

        Map<String, String> params = new HashMap<>();
        params.put("token", "123");
        params.put("action", "update");
        params.put("data[items][0][book_id]", bookId);
        params.put("data[items][0][cnt]", String.valueOf(booksCount));
        params.put("data[state]", "order");

        return params;
    }

    public static Map<String, String> paramsForDeleteBooksFromBasket(final String bookId) {

        Map<String, String> params = new HashMap<>();
        params.put("token", "123");
        params.put("action", "delete");
        params.put("data[items][]", bookId);
        params.put("data[state]", "order");

        return params;
    }

    public static Map<String, String> paramsForAddBookToBookmarks(final String bookId) {

        Map<String, String> params = new HashMap<>();
        params.put("token", "123");
        params.put("action", "create");
        params.put("data[items][]", bookId);

        return params;
    }

    public static Map<String, String> paramsForDeleteBookFromBookmarks(final String bookId) {

        Map<String, String> params = new HashMap<>();
        params.put("token", "123");
        params.put("action", "delete");
        params.put("data[items][]", bookId);

        return params;
    }

    public static Map<String, String> paramsForChangePersonalData(final User user) {

        Map<String, String> params = new HashMap<>();
        params.put("surname", user.getSurname());
        params.put("name", user.getName());
        params.put("second_name", user.getSecondName());
        params.put("email", user.getEmail());

        return params;
    }
}
