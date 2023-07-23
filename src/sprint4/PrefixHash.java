package sprint4;

import java.io.*;
import java.util.Arrays;

/**
 * @author valeriali on {11.07.2023}
 * @project algorithms
 */

public class PrefixHash {
    public static void main(String[] args) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int a = Integer.parseInt(bf.readLine());
            int m = Integer.parseInt(bf.readLine());
            String s = bf.readLine();

            int t = Integer.parseInt(bf.readLine());

            long[] prefixHashes = calculatePrefixHashes(a, m, s);
            long[] powers = calculatePowers(a, m, s.length());

//            System.out.println(Arrays.toString(powers));

            for (int i = 0; i < t; i++) {
                String[] digits = bf.readLine().split(" ");
                int l = Integer.parseInt(digits[0]);
                int r = Integer.parseInt(digits[1]);
                long substringHash = calculateSubstringHash(prefixHashes, powers, m, l, r);
                writer.write(String.valueOf(substringHash));
                writer.newLine();
            }
            writer.flush();
        }

    }

    public static long[] calculatePrefixHashes(int a, int m, String s) {
        int n = s.length();
        long[] prefixHashes = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixHashes[i] = (prefixHashes[i - 1] * a + (s.charAt(i - 1)) % m) % m;
        }

        return prefixHashes;
    }

    public static long[] calculatePowers(long a, long m, int n) {
        long[] powers = new long[n];
        long power = 1;

        for (int i = 0; i <= n - 1; i++) {
            power = (power * a) % m;
            powers[i] = power;
        }
        return powers;
    }

    public static long calculateSubstringHash(long[] prefixHashes, long[] powers, int m, int l, int r) {
        long substringHash = (prefixHashes[r] - (prefixHashes[l - 1] * powers[r - l] % m)) %m ;
        if (substringHash < 0) {
            substringHash += m;
        }
        return substringHash;
    }
}
