package chitaigorod.tests.api;

import chitaigorod.tests.api.models.User;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Map;
import java.util.stream.Stream;

import static chitaigorod.tests.api.models.TestUser.createUser1;
import static chitaigorod.tests.api.models.TestUser.createUser2;
import static chitaigorod.tests.api.models.TestUser.createUser3;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public final class ChitaiGorodAPITests extends APITestBase {

    @Tag("API")
    @ValueSource(strings = {"Sonic", "Death Note", "Dead Guilty", "The Art of War"})
    @ParameterizedTest(name = "Поиск книги по названию {0}")
    void searchBookTest(final String bookName) {

        step(String.format("Поиск книги с названием %s", bookName), () -> {
            assertThat(mainPage.searchBook(bookName)).contains(bookName);
        });
    }

    @Tag("API")
    @CsvSource(value = {"2944827, 11", "2942568, 1", "2918663, 9", "2604607, 5"})
    @ParameterizedTest(name = "Проверка добавления {1} книг {0} в корзину")
    void addBooksToBasketTest(final String bookId, final int booksCount) {

        step(String.format("Добавление %s книг в корзину", booksCount), () -> {
            mainPage.addBooksToBasket(bookId, booksCount);
        });

        step(String.format("Проверка, что в корзине %s книг", booksCount), () -> {
            assertThat(basketPage.booksInBasketCount()).isEqualTo(booksCount);
        });

        step("Удаление книги из корзины", () -> {
            basketPage.deleteBooksFromBasket(bookId);
        });
    }

    @Tag("API")
    @ValueSource(strings = {"2944827", "2942568", "2918663", "2604607"})
    @ParameterizedTest(name = "Проверка добавления книги {0} в закладки")
    void addBookToBookmarksTest(final String bookID) {

        step("Добавление книги в закладки", () -> {
            bookmarksPage.addBookToBookmarks(bookID);
        });

        step("Проверка наличия книги в закладках", () -> {
            assertThat(bookmarksPage.checkBookInBookmarksPage()).isEqualTo(bookID);
        });

        step("Удаление книги из закладок", () -> {
            bookmarksPage.deleteBooksFromBookmarks(bookID);
        });
    }

    @Tag("API")
    @MethodSource("changeUserDataTest")
    @ParameterizedTest(name = "Проверка смены личных данных пользователя")
    void changeUserDataTest(final User user) {

        step("Смена личных данных пользователя", () -> {
            personalPage.changePersonalData(user);
        });

        step("Проверка успешности смены личных данных", () -> {
            Map<String, String> userData = personalPage.checkPersonalData();

            assertThat(userData.get("surname")).isEqualTo(user.getSurname());
            assertThat(userData.get("name")).isEqualTo(user.getName());
            assertThat(userData.get("secondName")).isEqualTo(user.getSecondName());
        });
    }

    static Stream<Arguments> changeUserDataTest() {
        return Stream.of(
                Arguments.of(createUser1()),
                Arguments.of(createUser2()),
                Arguments.of(createUser3())
        );
    }
}
