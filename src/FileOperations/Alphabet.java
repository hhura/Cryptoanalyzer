package FileOperations;

import java.util.ArrayList;
import java.util.List;

public class Alphabet {
    private static final List<Character> alphabet = createAlphabet();

    public static List<Character> createAlphabet() {
        List<Character> alphabet = new ArrayList<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            alphabet.add(i);
        }
        for (char i = 'a'; i <= 'z'; i++) {
            alphabet.add(i);
        }
        for (char i = 'А'; i <= 'Я'; i++) {
            alphabet.add(i);
        }
        for (char i = 'а'; i <= 'я'; i++) {
            alphabet.add(i);
        }
        for (int i = 32; i < 64; i++) {
            alphabet.add((char) i);
        }
        return alphabet;
    }

    public static List<Character> getAlphabet() {
        return alphabet;
    }

}

