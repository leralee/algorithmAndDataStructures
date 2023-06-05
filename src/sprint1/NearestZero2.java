package sprint1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author valeriali on {02.06.2023}
 * @project algirithms
 */
public class NearestZero2 {

    public static int[] findNearestZero(String[] housesList, int housesCount){
        int[] result = new int[housesCount];
        int[] closerFromLeft = new int[housesCount];
        int[] closerFromRight = new int[housesCount];

        int cv = housesCount;
        for (int i = 0; i < housesCount; i++){
            if (housesList[i].equals("0")){
                cv = 0;
            } else {
                cv+=1;
            }
            closerFromLeft[i] = cv;
        }

        cv = housesCount;
        for (int i = housesCount-1; i >= 0; i--){
            if (housesList[i].equals("0")){
                cv = 0;
            } else {
                cv+=1;
            }
            closerFromRight[i] = cv;
        }

        for (int i = 0; i < housesCount; i++) {
            result[i] = Math.min(closerFromLeft[i], closerFromRight[i]);
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
