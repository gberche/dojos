package kata;

/**
 *
 */
public class FizzBuff {
    int currentIndex = 1;
    public String getNextLine() {
        String currentLine;
        boolean multipleOfThree = currentIndex % 3 == 0;
        boolean multipleOf5 = currentIndex % 5 == 0;
        if (multipleOfThree) {
            currentLine = "Fizz";
        } else {
            if (multipleOf5) {
                currentLine = "Buzz";
            } else {
                currentLine = Integer.toString(currentIndex) ;
            }
        }
        currentIndex++;
        return currentLine+ "\n";
    }
}
