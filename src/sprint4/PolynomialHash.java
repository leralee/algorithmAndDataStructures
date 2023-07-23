package sprint4;

import java.io.*;

/**
 * @author valeriali on {10.07.2023}
 * @project algorithms
 */
public class PolynomialHash {
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
        int a = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());


        String s1 = bufferedReader.readLine();


        long hash1 = calculateHash(a, m, s1);

        System.out.println(hash1);
        bufferedReader.close();
    }
}
