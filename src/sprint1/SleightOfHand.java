package sprint1;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author valeriali on {03.06.2023}
 * @project algirithms
 */
public class SleightOfHand {

    public static int calculateScore(int k, char[][] array){
        int n = 4;
        int score = 0;
        HashMap<Character, Integer> scores = new HashMap<>();
        for (int i = 1; i <= 9; i++) {
            scores.put(Character.forDigit(i, 10), 0);
        }


        for (int i=0; i<n; i++){
            for (int j=0; j<n;j++){
                if (array[i][j] == '.'){
                } else {
                    int newValue = scores.get(array[i][j])+1;
                    scores.put(array[i][j], newValue);
                }
            }
        }

        for (int i : scores.values()){
            if (i<=k*2 && i!=0) score++;
        }


        return score;

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            int k = readInt(reader);
            int n = 4;
            char[][] array = new char[n][n];

            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                array[i] = line.toCharArray();
            }
            int result = calculateScore(k, array);
            System.out.println(result);

        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}
