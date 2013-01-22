package kata;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 *
 */
public class FizzBuzzTest {

    @Test
    public void test() {
        String [] expected = {"1" ,
                "2" ,
                "Fizz" ,
                "4" ,
                "Buzz" ,
                "Fizz" ,
                "7" ,
                "8" ,
                "Fizz" ,
                "Buzz" ,
                "11" ,
                "Fizz" ,
                "13" ,
                "14" ,
                "FizzBuzz" ,
                "16" ,
                "17" ,
                "Fizz" ,
                "19" ,
                "Buzz"};

        FizzBuzz buzzer = new FizzBuzz();
        String value = buzzer.buildValue(1);
        assertThat(value).isEqualTo("1");
    }
}
