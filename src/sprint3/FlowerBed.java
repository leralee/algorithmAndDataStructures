package sprint3;

import java.io.*;
import java.util.*;

/**
 * @author valeriali on {29.06.2023}
 * @project algorithms
 */
public class FlowerBed {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] array = new int[n][2];


        for (int i = 0; i < n; i++){
            String[] readLine = bufferedReader.readLine().split(" ");
            array[i][0] = Integer.parseInt(readLine[0]);
            array[i][1] = Integer.parseInt(readLine[1]);
        }

        Arrays.sort(array, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        result.add(array[0]);

        for (int i = 1; i < n; i++) {
            int[] current = array[i];
            int[] previous = result.get(result.size() - 1);

            if (current[0] <= previous[1]) {
                previous[1] = Math.max(previous[1], current[1]);
            } else {
                result.add(current);
            }
        }


        for (int[] r: result){
            bufferedWriter.write(r[0] + " " + r[1]);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();

    }

}
