package sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author valeriali on {01.06.2023}
 * @project algirithms
 */
public class WeatherRandomness {
    private static int getWeatherRandomness(List<Integer> temperatures, int numberOfDays) {
        int count = 0;
        if (numberOfDays == 1){
            return 1;
        }
        if (temperatures.get(0)>temperatures.get(1)){
            count+=1;
        }
        for (int i=1; i<numberOfDays-1; i++){
            if (temperatures.get(i) > temperatures.get(i-1) && temperatures.get(i) > temperatures.get(i+1)){
                count+=1;
            }
        }
        if (temperatures.get(numberOfDays-1) > temperatures.get(numberOfDays-2)){
            count+=1;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfDays = readInt(reader);
            List<Integer> temperatures = readList(reader);
            int chaosNumber = getWeatherRandomness(temperatures, numberOfDays);
            System.out.println(chaosNumber);
        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer :: parseInt)
                .collect(Collectors.toList());
    }
}
