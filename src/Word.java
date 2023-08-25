public class Word {
    int length;
    Letter[] letters;

    public Word() {
        this(5);
    }

    public Word(int length) {
        this.length = length;
        this.letters = new Letter[length];
    }
}
