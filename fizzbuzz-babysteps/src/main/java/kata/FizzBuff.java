package kata;

/**
 *
 */
public class FizzBuff {
    int currentIndex = 1;
    public String getNextLine() {
        String currentLine = currentIndex + "\n";
        currentIndex++;
        return currentLine;
    }
}
