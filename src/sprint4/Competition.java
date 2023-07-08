package sprint4;


import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * @author valeriali on {07.07.2023}
 * @project algorithms
 */
public class Competition {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] rounds = new int[n];

        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            rounds[i] = Integer.parseInt(input[i]);
        }

        int maxSeq = 0;
        int sum = 0;

        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);

        for (int i = 0; i < rounds.length; i++) {
            if (rounds[i] == 0) {
                sum++;
            } else {
                sum--;
            }

            if (sumToIndex.containsKey(sum)) {
                int prevIndex = sumToIndex.get(sum);
                int length = i - prevIndex;
                maxSeq = Math.max(maxSeq, length);
            } else {
                sumToIndex.put(sum, i);
            }
        }

        writer.write(maxSeq + "");

        writer.flush();
        writer.close();
        reader.close();
    }
}
