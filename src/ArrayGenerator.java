import java.util.*;
import java.io.File;

public class ArrayGenerator {
    private final char[] greenLetters;
    private final char[] yellowLetters;
    private final char[] possibleLetters;
    private ArrayList<char[]> possibleWords = new ArrayList<>();
    private ArrayList<char[]> dictionary;

    public ArrayGenerator(char[] greenLetters, char[] yellowLetters, char[] possibleLetters) {
        this.greenLetters = greenLetters;
        this.yellowLetters = yellowLetters;
        this.possibleLetters = possibleLetters;
        this.dictionary = new ArrayList<>();
        generateWords();
    }

    public void generateWords() {
        try {
            Scanner reader = new Scanner(new File("dictionary.txt"));
            while (reader.hasNext()) {
                String word = reader.next();
                if (word.length() == 5) dictionary.add(word.toCharArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (char[] word : dictionary) {
            if (verifyWord(word)) {
                possibleWords.add(word);
            }
        }
    }


    public boolean verifyWord(char[] word) {
        int index = 0;
        for (char greenLetter : greenLetters) {
            if (!java.lang.Character.isAlphabetic(greenLetter)) {
                index++;
                continue;
            }
            if (!(greenLetter == word[index])) {
                return false;
            }
            index ++;
        }
        for (char yellowLetter : yellowLetters) {
            boolean inWord = false;
            for (char letter : word) {
                if (letter == yellowLetter) {
                    inWord = true;
                }
            }
            if (!inWord) {
                return false;
            }
        }
        for (char letter : word) {
            boolean validLetter = false;
            for (char greenLetter : greenLetters) {
                if (letter == greenLetter) {
                    validLetter = true;
                    break;
                }
            }
            for (char yellowLetter : yellowLetters) {
                if (letter == yellowLetter) {
                    validLetter = true;
                    break;
                }
            }
            for (char possibleLetter : possibleLetters) {
                if (letter == possibleLetter) {
                    validLetter = true;
                    break;
                }
            }
            if (!validLetter) {
                return false;
            }
        }
        return true;
    }

    public void printWordList() {
        System.out.printf("There are %d words that match your criteria!\n", possibleWords.size());
        for (char[] word : possibleWords) {
            for (char letter : word) {
                System.out.print(letter);
            }
            System.out.println();
        }
    }
    public void addGreenLetter(char letter, int index) {
        if (java.lang.Character.isAlphabetic(greenLetters[index])) {
            System.out.println("You already found this letter!");
        } else {
            greenLetters[index] = letter;
        }
    }

    public void addYellowLetter(char letter, int index) {
        if (java.lang.Character.isAlphabetic(greenLetters[index])) {
            System.out.println("You already found this letter!");
        } else {
            yellowLetters[index] = letter;
        }
    }
}
