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

            //
                "16" ,
                "17" ,
                "Fizz" ,
                "19" ,
                "Buzz" ,
                "Fizz" ,
                "22" ,
                "23" ,
                "Fizz" ,
                "Buzz" ,
                "26" ,
                "Fizz" ,
                "28" ,
                "29" ,
                "FizzBuzz" ,
          };

        FizzBuzz buzzer = new FizzBuzz();

        for(  int index = 1; index<=30;index++) {
            assertValue(buzzer, index, expected[index-1]);
        }

    }

    private void assertValue(FizzBuzz buzzer, int index, String expected1) {
        String value = buzzer.buildValue(index);
        assertThat(value).isEqualTo(expected1);
    }
}
