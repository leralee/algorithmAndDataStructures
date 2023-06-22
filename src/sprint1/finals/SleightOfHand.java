package sprint1.finals;//88064830
import java.io.*;

/**
 * @author valeriali on {03.06.2023}
 * @project algirithms
 */
public class SleightOfHand {

    public static int calculateScore(int k, char[][] array){
        final int maxValue = 9;
        int n = 4;
        int score = 0;
        int[] scores = new int[maxValue+1];

        for (int i=0; i<n; i++){
            for (int j=0; j<n;j++){
                if (array[i][j] == '.'){
                } else {
                    scores[array[i][j]-'0'] ++;
                }
            }
        }

        for (int i : scores){
            if (i<=k*2 && i!=0) score ++;
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
