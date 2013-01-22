package kata;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 *
 */
public class FizzBuzzTest {
    String magicNumber = "X";

    @Test
    public void test() {
        String [] expected = { magicNumber ,
                magicNumber ,
                "Fizz" ,
                magicNumber ,
                "Buzz" ,
                "Fizz" ,
                magicNumber ,
                magicNumber ,
                "Fizz" ,
                "Buzz" ,
                magicNumber ,
                "Fizz" ,
                magicNumber ,
                magicNumber ,
                "FizzBuzz" ,

          };

        FizzBuzz buzzer = new FizzBuzz();

        for(  int index = 1; index<=500;index++) {
            assertValue(buzzer, index, expected[(index-1)%15]);
        }

    }

    private void assertValue(FizzBuzz buzzer, int index, String expected1) {
        String value = buzzer.buildValue(index);
        if (expected1.equals(magicNumber)) {
            expected1 = Integer.toString(index);
        }
        assertThat(value).isEqualTo(expected1);
    }
}
