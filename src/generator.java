import java.util.*;
import java.lang.Character;

public class generator {
    public static void main(String[] args) {
        char[] greenLetters = {'0', '0', '0', '0', '0'};
        char[] yellowLetters = {'a', 'o'};
        char[] possibleLetters = {'q', 'j', 'k', 'z', 'x', 'v',};
        ArrayGenerator possibleWords = new ArrayGenerator(greenLetters, yellowLetters, possibleLetters);
        possibleWords.printWordList();
    }
}
