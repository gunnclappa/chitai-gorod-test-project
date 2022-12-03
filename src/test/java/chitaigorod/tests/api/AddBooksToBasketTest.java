package chitaigorod.tests.api;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public final class AddBooksToBasketTest extends APITestBase {

    @CsvSource(value = {"2944827, 11", "2942568, 1", "2918663, 9", "2604607, 5"})
    @ParameterizedTest(name = "Проверка добавления {1} книг {0} в корзину")
    void addBooksToBasketTest(final String bookId, final int booksCount) {

        step(String.format("Добавление %s книг в корзину", booksCount), () -> {
            mainPageAPI.addBooksToBasket(bookId, booksCount);
        });

        step(String.format("Проверка, что в корзине %s книг", booksCount), () -> {
            assertThat(basketAPI.booksInBasketCount()).isEqualTo(booksCount);
        });

        step("Удаление книги из корзины", () -> {
            basketAPI.deleteBooksFromBasket(bookId);
        });
    }
}
