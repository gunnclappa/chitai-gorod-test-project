package chitaigorod.tests.api;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public final class AddBookToBookmarksTest extends APITestBase {

    @ValueSource(strings = {"2944827", "2942568", "2918663", "2604607"})
    @ParameterizedTest(name = "Проверка добавления книги {0} в закладки")
    void addBookToBookmarksTest(final String bookID) {

        step("Добавление книги в закладки", () ->
                bookmarksAPI.addBookToBookmarks(bookID));

        step("Проверка наличия книги в закладках", () ->
                assertThat(bookmarksAPI.checkBookInBookmarksPage()).isEqualTo(bookID));

        step("Удаление книги из закладок", () ->
                bookmarksAPI.deleteBooksFromBookmarks(bookID));
    }
}
