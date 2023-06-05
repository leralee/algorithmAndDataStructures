package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author valeriali on {01.06.2023}
 * @project algirithms
 */
public class BinaryNumber {
    private static String getBinaryNumber(int n) {
        StringBuilder result = new StringBuilder();
        if (n==0) return "0";
        while (n != 1) {
            result.insert(0, n%2);
            n = n / 2;
        }
        result.insert(0, n);
        return result.toString();

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            System.out.println(getBinaryNumber(n));
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
