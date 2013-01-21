package kata;

/**
 *
 */
public class FizzBuff {
    int currentIndex = 0;
    public String getNextLine() {
        currentIndex++;
        return currentIndex + "\n";
    }
}
