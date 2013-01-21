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
        } else {
            currentLine = Integer.toString(currentIndex) ;
        }
        currentIndex++;
        return currentLine+ "\n";
    }
}
