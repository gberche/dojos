package kata;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Edited in at-home2
 */
public class FizzBuzzTest {

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


}
