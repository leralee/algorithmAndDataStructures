import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author valeriali on {09.06.2023}
 * @project algirithms
 */
public class ExtraLetter {
    private static char getExcessiveLetter(String s, String t) {
        int xor = 0;

        // Применяем XOR ко всем символам строки s
        for (char c : s.toCharArray()) {
            System.out.println((int) c);
            xor ^= c;
            System.out.println(xor);
        }


        // Применяем XOR ко всем символам строки t
        for (char c : t.toCharArray()) {
            xor ^= c;
        }
        System.out.println(xor);

        // Возвращаем символ с ненулевым значением
        return (char) xor;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            String t = reader.readLine();
            System.out.println(getExcessiveLetter(s, t));

        }
    }
}
