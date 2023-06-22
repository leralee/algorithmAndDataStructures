package sprint1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author valeriali on {05.06.2023}
 * @project algirithms
 */
public class Factorization {
    private static List<Integer> factorize(int n) {
        List<Integer> result = new ArrayList<>();

        int multiplier = 2;
        while (n > 1 && multiplier*multiplier <= n){
            if (n%multiplier == 0){
                result.add(multiplier);
                n/=multiplier;
            }else if (multiplier == 2) {
                multiplier++;
            }else {
                multiplier+=2;
            }
        }
        if (n!=1){
            result.add(n);
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = readInt(reader);
            List<Integer> factorization = factorize(n);
            for (int elem : factorization) {
                writer.write(elem + " ");
            }
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
