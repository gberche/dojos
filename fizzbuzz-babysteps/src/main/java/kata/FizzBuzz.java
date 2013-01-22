package kata;

/**
 *
 */
public class FizzBuzz {
    public String buildValue(int i) {
        if (i %3 ==0) {
            return "Fizz";
        } else {
             return Integer.toString(i);
        }
    }
}
