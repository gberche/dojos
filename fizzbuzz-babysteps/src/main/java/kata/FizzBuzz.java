package kata;

/**
 *
 */
public class FizzBuzz {
    public String buildValue(int i) {
        if (i %3 ==0) {
            return "Fizz";

        } else if (i %5 ==0) {
            return "Buzz";
        } else {
             return Integer.toString(i);
        }
    }
}
