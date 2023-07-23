package sprint4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author valeriali on {21.07.2023}
 * @project algorithms
 */
public class MnogoGosha {
    public static void main(String[] args) throws IOException {
//        System.out.println("ardpfwtidgimeuajnxavunvxsbcivptittvbpkqzsbzpsbzpyoamfxmffhrpoczagetufjfpahpkmnyflkxpmmckwsxpfjfprohzutfjfpdopzeculmfylfftvxyfkdjbqavunqbpzixmnpzectmmfbuxhfhxaamcivp".length());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] numbers = br.readLine().split(" ");
        int n = Integer.parseInt(numbers[0]);
        int k = Integer.parseInt(numbers[1]);
        String str = br.readLine();

        List<Integer> result = getPositions(str, n, k);
        for (int index : result) {
            bw.write(index + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static List<Integer> getPositions(String str, int n, int k) {
        int base = 3;
        int mod = 10007;

        HashMap<Integer, Integer> counter = new HashMap<>();
        HashMap<Integer, Integer> hashToPos = new HashMap<>();

        int hash = getHash(str.substring(0, n), base, mod);
        int power = getPower(n, base, mod);

        counter.put(hash, 1);
        hashToPos.put(hash, 0);

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i + n - 1 < str.length(); i++) {
            hash = (hash + mod - (int) str.charAt(i - 1) * power % mod) % mod;
            hash = (hash * base % mod + (int) str.charAt(i + n - 1)) % mod;

//            int startPos = hashToPos.get(hash);
//            if (str.substring(startPos, startPos + n).equals(str.substring(i, i + n))) {
                counter.put(hash, counter.getOrDefault(hash, 0) + 1);
//            }

//            if (hash == 4328) {
//                System.out.println("fef");
//                System.out.println(i);
//                System.out.println(str.substring(i, i + n));
//            }

            if (counter.get(hash) == 1) {
                hashToPos.put(hash, i);
            }
            if (counter.get(hash) == k) {
                result.add(hashToPos.get(hash));

            }
        }
        return result;

    }

    public static int getHash(String str, int base, int mod) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash * base % mod + (int) str.charAt(i)) % mod;
        }
        return hash;
    }

    public static int getPower(int n, int base, int mod) {
        int power = 1;
        for (int i = 1; i < n; i++) {
            power = (power * base) % mod;
        }
        return power;
    }
}
