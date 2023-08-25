import java.util.ArrayList;
import java.util.Scanner;

public class Letter {
    boolean found;
    char greenLetter;
    int position;
    ArrayList<Character> yellowLetters;

    public Letter(int position) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Have you found letter %d yet? Y/N", position);
            String line = scanner.nextLine();
            if (line.toLowerCase().charAt(0) == 'y') {
                found = true;

                String line2 = scanner.nextLine();
            }
            else if (line.toLowerCase().charAt(0) == 'n') {
                found = false;
            }
        }
    }
}
