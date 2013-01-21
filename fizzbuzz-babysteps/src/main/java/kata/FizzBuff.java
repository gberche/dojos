package kata;

/**
 *
 */
public class FizzBuff {
    int currentIndex = 1;
    public String getNextLine() {
        String currentLine;
        if (currentIndex %3 == 0) {
            currentLine = "Fizz";
        } else if (currentIndex %5 == 0) {
            currentLine = "Buzz";
        } else {
            currentLine = Integer.toString(currentIndex) ;
        }
        currentIndex++;
        return currentLine+ "\n";
    }
}
