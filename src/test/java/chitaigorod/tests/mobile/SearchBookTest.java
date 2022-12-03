package chitaigorod.tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class SearchBookTest extends MobileTestBase {

    @Test
    @DisplayName("Поиск книги по названию")
    void searchBookTest() {

        final String bookName = "Death Note";

        step(String.format("Поиск книги %s", bookName), () -> {
            mainPage.search();
            searchPage.search(bookName);
        });

        step(String.format("Проверка отображения книги %s", bookName), () -> {
            searchPage.checkProduct(bookName);
        });
    }
}
