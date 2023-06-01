import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author valeriali on {20.05.2023}
 * @project algirithms
 */
public class MovingAverage {
    private static List<Double> movingAverage(int n, List<Integer> arr, int windowSize) {
        List<Double> movingAverageList = new ArrayList<>();

        double current_sum = 0;
        for (int i=0; i<windowSize; i++){
            current_sum+=arr.get(i);
        }

        movingAverageList.add(current_sum / windowSize);

        for (int i=0; i<n-windowSize; i++){
            current_sum-= arr.get(i);
            current_sum+=arr.get(i+windowSize);
            double current_avg = current_sum / windowSize;
            movingAverageList.add(current_avg);
        }

        return movingAverageList;

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            int windowSize = readInt(reader);
            List<Double> result = movingAverage(n, arr, windowSize);
            for (double elem : result) {
                writer.write(elem + " ");
            }
        }
    }


    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
