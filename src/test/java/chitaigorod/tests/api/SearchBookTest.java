package chitaigorod.tests.api;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public final class SearchBookTest extends APITestBase {

    @ValueSource(strings = {"Sonic", "Death Note", "Dead Guilty", "The Art of War"})
    @ParameterizedTest(name = "Поиск книги по названию {0}")
    void searchBookTest(final String bookName) {

        step(String.format("Поиск книги с названием %s", bookName), () ->
                assertThat(mainPageAPI.searchBook(bookName)).contains(bookName));
    }
}
