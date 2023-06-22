package sprint1.finals;//88064781
import java.io.*;
import java.util.Arrays;

/**
 * @author valeriali on {02.06.2023}
 * @project algorithms
 */
public class NearestZero2 {

    public static int[] findNearestZero(String[] housesList, int housesCount) {

        int[] result = new int[housesCount];
        int cv = housesCount;

        for (int i = 0; i < housesCount; i++) {
            if (housesList[i].equals("0")) {
                cv = 0;
            } else {
                cv += 1;
            }
            result[i] = cv;
        }
        System.out.println(Arrays.toString(result));

        cv = housesCount;
        for (int i = housesCount - 1; i >= 0; i--) {
            if (housesList[i].equals("0")) {
                cv = 0;
            } else {
                cv += 1;
            }
            System.out.println(cv);
            System.out.println(result[i]);
            result[i] = Math.min(result[i], cv);
        }


        return result;
    }



    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int housesCount = readInt(reader);
            String[] housesList = reader.readLine().split(" ");
            int[] result = findNearestZero(housesList, housesCount);
            for (int elem : result) {
                writer.write(elem + " ");
            }
            writer.flush();


        }
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }




}
