package kata;

/**
 *
 */
public class FizzBuzz {
    public String buildValue(int i) {
        boolean multiple_of_three = i % 3 == 0;
        boolean multiple_of_five = i % 5 == 0;
        if (multiple_of_three && multiple_of_five) {
            return "FizzBuzz";
        } else         if (multiple_of_three) {
            return "Fizz";
        } else if (multiple_of_five) {
                return "Buzz";
        } else {
                 return Integer.toString(i);
            }
    }
}
