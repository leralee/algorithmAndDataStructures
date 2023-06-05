package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author valeriali on {01.06.2023}
 * @project algirithms
 */
public class LongestWord {
    private static String getLongestWord(int textLength, String text) {
        String longestWord = "";
        for (String s : text.split(" ")) {
            int lengthText = s.length();
            if (lengthText > longestWord.length()) {
                longestWord = s;
            }
        }
        return longestWord;
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int textLength = readInt(reader);
            String text = reader.readLine();
            String longestWord = getLongestWord(textLength, text);
            System.out.println(longestWord);
            System.out.println(longestWord.length());
        }

    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
