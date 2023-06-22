package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author valeriali on {05.06.2023}
 * @project algirithms
 */
public class PowerOfFour {
    private static boolean isPowerOfFour(int n) {
        return (Math.log(n) / Math.log(4)) % 1 == 0;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = readInt(reader);
            if (isPowerOfFour(n)) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
