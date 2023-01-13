import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MethodsForTestTests {
    MethodsForTest methodsForTest = new MethodsForTest();

    @Test
    public void binSearchTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int searchElement = 3;

        boolean result = methodsForTest.binSearch(list, searchElement);

        Assertions.assertTrue(result);
    }

    @Test
    public void bubbleSortTest() {
        List<Character> list = Arrays.asList('x', 'a', 'y', 'd');
        List<Character> expected = Arrays.asList('a', 'd', 'x', 'y');

        List<Character> result = methodsForTest.bubbleSort(list);

        Assertions.assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void wordsInTextCounterTest() {
        String text = "Moscow is moscow";
        String word = "moscow";
        int expected = 2;

        int result = methodsForTest.wordsInTextCounter(text, word);

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("fibonacheSource")
    public void fibonacheTest(int num, BigInteger expected) {
        Assertions.assertEquals(expected, methodsForTest.fibonache(num));
    }


    private static Stream<Arguments> fibonacheSource() {
        return Stream.of(
                Arguments.of(10, "55"),
                Arguments.of(11, "89"),
                Arguments.of(100, "354224848179261915075")
        );
    }

    @ParameterizedTest
    @MethodSource("currencyExchangeSource")
    public void currencyExchangeTest(double amount, double exchangeCoef, double expected) {
        Assertions.assertEquals(expected, methodsForTest.currencyExchange(amount, exchangeCoef), 0.01);
    }

    public static Stream<Arguments> currencyExchangeSource() {
        return Stream.of(
                Arguments.of(1000.0, 0.01470, 14.70),
                Arguments.of(1000000.0, 0.01470, 14700)
        );
    }

    @Test
    public void binSearchHamcrest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int searchElement = 3;

        MatcherAssert.assertThat(list, Matchers.hasItem(searchElement));
    }

    @Test
    public void bubbleSortHamcrest() {
        List<Character> list = Arrays.asList('x', 'a', 'y', 'd');

        List<Character> result = methodsForTest.bubbleSort(list);

        MatcherAssert.assertThat(result, Matchers.contains('a', 'd', 'x', 'y'));
    }

    @Test
    public void wordsInTextCounterHamcrest() {
        String text = "Moscow is moscow";
        String word = "moscow";
        MatcherAssert.assertThat(2, Matchers.equalTo(methodsForTest.wordsInTextCounter(text, word)));
    }

    @Test
    public void fibonacheHamcrest() {
        MatcherAssert.assertThat(BigInteger.valueOf(55), Matchers.equalTo(methodsForTest.fibonache(10)));
    }

    @Test
    public void currencyExchangeHamcrest() {
        MatcherAssert.assertThat(14.70, Matchers.equalTo(methodsForTest.currencyExchange(1000, 0.01470)));
    }

}
