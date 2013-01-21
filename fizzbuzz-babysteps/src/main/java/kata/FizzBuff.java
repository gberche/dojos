package kata;

/**
 *
 */
public class FizzBuff {
    int currentIndex = 1;
    public String getNextLine() {
        String currentLine;
        if (currentIndex %3 == 0) {
            currentLine = "Fizz"+ "\n";
        } else {
            currentLine = currentIndex + "\n";
        }
        currentIndex++;
        return currentLine;
    }
}
