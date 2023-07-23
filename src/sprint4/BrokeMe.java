package sprint4; /**
 * @author valeriali on {11.07.2023}
 * @project algorithms
 */

import java.io.*;
import java.util.*;

public class BrokeMe {
    public static long calculateHash(int a, int m, String s) {
        int n = s.length();
        long hash = 0;
        long power = 1;


        for (int i = n - 1; i >= 0; i--) {
            hash = (hash + ((int) s.charAt(i) * power) % m) % m;
            power = (power * a) % m;
        }

        return hash;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, String> hashToValue = new HashMap<>();

        int a = 1000;
        int m = 123987123;

        while (true) {
            String s = generateRandomString();
            int hash = (int) calculateHash(a, m, s);


            if (hashToValue.containsKey(hash)) {
                String collidingValue = hashToValue.get(hash);
                System.out.println(collidingValue);
                System.out.println(s);
                break;
            } else {
                hashToValue.put(hash, s);
            }
        }

        bufferedReader.close();
    }


    public static String generateRandomString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int length = random.nextInt(8, 100) + 1; // Длина генерируемой строки
        String characters = "abcdefghijklmnopqrstuvwxyz"; // Набор символов


        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
