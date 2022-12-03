package chitaigorod.tests.ui;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;

public final class SearchBookTest extends UITestBase {

    @ValueSource(strings = {"Death Note", "Dead Guilty", "The Art of War"})
    @ParameterizedTest(name = "Поиск книги по названию {0}")
    void searchBookTest(final String bookName) {

        step(String.format("Поиск книги %s", bookName), () ->
                mainPage.searchBook(bookName));

        step(String.format("Проверка отображения книги %s", bookName), () ->
                searchPage.checkIfBookIsFound(bookName));
    }
}
