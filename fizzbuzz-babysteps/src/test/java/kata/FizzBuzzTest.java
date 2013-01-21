package kata;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Edited in at-home2
 */
public class FizzBuzzTest {

    private static final String[] EXPECTED_LINES = {"1\n",
            "2\n",
            "Fizz\n",
            "4\n",
            "Buzz\n",
            "Fizz\n",
            "7\n",
            "8\n",
            "Fizz\n",
            "Buzz\n",
            "11\n",
            "Fizz\n",
            "13\n",
            "14\n",
            "FizzBuzz\n",
            "16\n",
            "17\n",
            "Fizz\n",
            "19\n",
            "Buzz"};
    private FizzBuff fizzBuff;

    @Before
    public void setUp() {
        fizzBuff = new FizzBuff();
    }


    @Test
    public void fizzBuzzShouldReturnNonNullNextLine() {
        String nextLine = fizzBuff.getNextLine();
        assertThat(nextLine).isNotNull();
    }

    @Test
    public void fizzBuzzShouldReturnExpectedLines() {
        int max = 3;
        for (int currentLine=1; currentLine< max; currentLine++) {
            assertExpectedLineReturned(currentLine);
        }
    }
    @Test
    public void fizzBuzzShouldReturn_Fizz_on_3rd_sample() {
        int max = 4;
        for (int currentLine=1; currentLine< max; currentLine++) {
            assertExpectedLineReturned(currentLine);
        }
    }


    /**
     *
     * @param lineIndex index starting from 1
     */
    private void assertExpectedLineReturned(int lineIndex) {
        String nextLine = fizzBuff.getNextLine();
        assertThat(nextLine).isEqualTo(EXPECTED_LINES[lineIndex -1]);
    }

}
