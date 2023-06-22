package sprint2;

import java.io.*;
import java.util.StringTokenizer;


/**
 * @author valeriali on {13.06.2023}
 * @project algirithms
 */
public class Monitoring {

    public static int[][] transposition(int n, int m, int[][] mas){
        int[][] result = new int[m][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                result[j][i] = mas[i][j];
            }
        }

        return result;

    }
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            // Чтение размерности матрицы
            int n = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());


            // Создание и чтение матрицы
            int[][] mas = new int[n][m];
            for (int i = 0; i < n; i++){
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < m; j++){
                    mas[i][j] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            int[][] result = transposition(n, m , mas);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    sb.append(result[i][j]).append(" ");
                }
                sb.append("\n");
            }

            writer.write(sb.toString());
            writer.flush();
        }

    }

}
